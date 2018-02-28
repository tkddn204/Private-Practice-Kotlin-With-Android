package me.ssangwoo.kotlinlecture.view.main.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_kotlin_recycler_view.*
import me.ssangwoo.kotlinlecture.R

class KotlinRecyclerViewActivity : AppCompatActivity() {

    private val recyclerViewSimpleAdapter: RecyclerViewSimpleAdapter by lazy {
        RecyclerViewSimpleAdapter(this@KotlinRecyclerViewActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_recycler_view)

        recycler_view.run {
            layoutManager = LinearLayoutManager(this@KotlinRecyclerViewActivity)
            adapter = recyclerViewSimpleAdapter
        }

        getList().forEach {
            recyclerViewSimpleAdapter.addItem(it)
        }
        recyclerViewSimpleAdapter.notifyDataSetChanged()
    }

    private fun getList(): List<String> = (0..100).map { "index $it" }
}
