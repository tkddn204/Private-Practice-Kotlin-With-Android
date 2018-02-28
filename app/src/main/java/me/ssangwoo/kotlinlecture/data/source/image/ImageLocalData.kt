package me.ssangwoo.kotlinlecture.data.source.image

import android.media.Image
import me.ssangwoo.kotlinlecture.data.source.ImageData
import me.ssangwoo.kotlinlecture.util.random

/**
 * Created by 쌍우 on 2018-02-27.
 */
class ImageLocalData : ImageDataSource {
    override fun loadImageFileName(fileName: (String) -> Unit) {
        fileName(String.format("image_%02d", (1..5).random()))
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        val list = mutableListOf<ImageData>()
        for (index in 1..size) {
            val name = String.format("image_%02d", (1..5).random())
            list.add(ImageData(name, name))
        }
        imageDataList(list)
    }
}