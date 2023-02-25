package ru.myitschool.lab23

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate


data class Operation(val type: String, val date: LocalDate, val amount: Double)


class MainActivity : AppCompatActivity() {

    private var list: List<Operation>? = null
    val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler: RecyclerView = findViewById(R.id.recyclerView)
        recycler.adapter = MyAdapter(list)
        recycler.layoutManager = LinearLayoutManager(this)

        myViewModel.list.observe(this) {
            // наблюдает за изменение списка
        }
        // для баланса аналогично
    }
}