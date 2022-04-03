package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_main)

        initNavigation()

        main_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    val bundle = Bundle()
                    bundle.putParcelable("film", film)
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(filmsDataBase)
    }

        private fun initNavigation() {
            topAppBar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.settings -> {
                        Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }

            bottom_navigation.setOnNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.favorites -> {
                        Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.watch_later -> {
                        Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.selections -> {
                        Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }
    }