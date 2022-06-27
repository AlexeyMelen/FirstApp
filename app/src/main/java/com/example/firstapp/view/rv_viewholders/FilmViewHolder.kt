package com.example.firstapp.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.domain.Film
import kotlinx.android.synthetic.main.film_item.view.*

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description
    private val ratingDonut = itemView.rating_donut

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())
    }
}