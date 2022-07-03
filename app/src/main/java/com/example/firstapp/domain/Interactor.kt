package com.example.firstapp.domain

import com.example.firstapp.data.Entity.TmdbResultsDto
import com.example.firstapp.data.*
import com.example.firstapp.utils.Converter
import com.example.firstapp.viewmodel.HomeFragmentViewModel
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(call: Call<TmdbResultsDto>, response: Response<TmdbResultsDto>) {
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.tmdbFilms))
            }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}