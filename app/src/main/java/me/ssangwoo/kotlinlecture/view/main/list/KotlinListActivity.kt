package me.ssangwoo.kotlinlecture.view.main.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kotlin_list.*
import me.ssangwoo.kotlinlecture.R

class KotlinListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_list)

        view_holder_list_view.adapter = ViewHolderAdapter(this, 0, getList())
    }

    private fun getList(): List<String> = (0..100).map { "index $it" }
}
