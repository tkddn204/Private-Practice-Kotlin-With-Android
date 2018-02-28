package me.ssangwoo.kotlinlecture.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.ssangwoo.kotlinlecture.R

/**
 * Created by 쌍우 on 2018-02-23.
 */
class CameraFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            =  inflater?.inflate(R.layout.fragment_etc, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        message.setText(arguments?.getInt(KEY_TITLE) ?: 0)
    }

    companion object {
        val KEY_TITLE = "key-title"
    }
}