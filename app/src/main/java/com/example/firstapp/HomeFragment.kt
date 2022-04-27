package com.example.firstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.appcompat.widget.SearchView
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    val filmsDataBase = listOf(
        Film("Mandalorian", R.drawable.mandalorian, "Одинокий мандалорец-наёмник живёт на краю обитаемой галактики, куда не дотягивается закон Новой Республики. Представитель некогда могучей расы благородных воинов теперь вынужден влачить жалкое существование среди отбросов общества."),
        Film("Lightyear", R.drawable.lightyear, "История приключений легендарного космического рейнджера Базза Лайтера."),
        Film("Squid Game", R.drawable.squid_game, "Сюжет сериала прост: погрязшие в долгах и отчаявшиеся корейцы участвуют в жестоких играх в надежде выиграть миллиарды."),
        Film("It", R.drawable.it, "Злобный клоун терроризирует подростков. Экранизация романа Стивена Кинга с жутким Биллом Скарсгардом."),
        Film("Mad Max: Fury Road", R.drawable.mad_max, "Война за ресурсы привела к краху цивилизации, на просторах постапокалиптической пустоши Австралии царствуют безумие и дикие банды на самодельном транспорте."),
        Film("Matrix Resurrections", R.drawable.matrix, "В двух реальностях Нео снова придется выбирать, следовать ли за белым кроликом."),
        Film("Morbius", R.drawable.morbius, "Майкл Морбиус с детства страдает от редкого заболевания крови и всю свою сознательную жизнь посвятил поискам лекарства, но это меняет его тело и преврощает в кровожадного монстра."),
        Film("Jurassic World: Dominion", R.drawable.jurassic_world, "Новая история из жизни динозавров в XXI веке. Древние ящеры и современные люди с переменным успехом пытаются сосуществовать рядом."),
        Film("Hobbit: An Unexpected Journey", R.drawable.hobbit, "Хоббит Бильбо Бэггинс пускается в грандиозный поход, целью которого является отвоевание утраченного королевства гномов Эребор у дракона Смауга.")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(home_fragment_root, requireActivity(), 1)

        initSearchView()

        initRecyckler()
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initSearchView() {
        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                val result = filmsDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })
    }

    private fun initRecyckler() {
        main_recycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}