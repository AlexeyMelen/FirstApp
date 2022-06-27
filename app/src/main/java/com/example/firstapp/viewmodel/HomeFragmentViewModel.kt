package com.example.firstapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.App
import com.example.firstapp.domain.Film
import com.example.firstapp.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData = MutableLiveData<List<Film>>()
    private var interactor: Interactor = App.instance.interactor
    init {


        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}