package me.ssangwoo.kotlinlecture.view.main.home.adapter.model

import me.ssangwoo.kotlinlecture.data.source.ImageData

/**
 * Created by 쌍우 on 2018-02-27.
 */
interface ImageRecyclerModel {
    fun addItem(imageData: ImageData)

    fun getItemCount(): Int

    fun notifyImageDataSetChange()
}