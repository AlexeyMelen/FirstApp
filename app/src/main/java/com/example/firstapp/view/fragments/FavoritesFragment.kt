package com.example.firstapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.view.rv_adapters.FilmListRecyclerAdapter
import com.example.firstapp.view.MainActivity
import com.example.firstapp.R
import com.example.firstapp.view.rv_adapters.TopSpacingItemDecoration
import com.example.firstapp.domain.Film
import com.example.firstapp.utils.AnimationHelper
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoritesList: List<Film> = emptyList()

        AnimationHelper.performFragmentCircularRevealAnimation(favorites_fragment_root, requireActivity(), 2)

        favorites_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(favoritesList)
    }
}