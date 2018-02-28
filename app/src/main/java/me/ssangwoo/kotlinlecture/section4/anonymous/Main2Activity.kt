package me.ssangwoo.kotlinlecture.section4.anonymous

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import me.ssangwoo.kotlinlecture.R

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setOnClick(object: MyOnClickListener {
            override fun onClick() {

            }
        })
    }

    private fun setOnClick(onClick: MyOnClickListener) {
        onClick.onClick()
    }

    interface MyOnClickListener {
        fun onClick()
    }
}
