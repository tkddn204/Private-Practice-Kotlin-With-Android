package me.ssangwoo.kotlinlecture.data.source.image

import me.ssangwoo.kotlinlecture.data.source.ImageData

/**
 * Created by 쌍우 on 2018-02-27.
 */
interface ImageDataSource {
    fun loadImageFileName(fileName: (String) -> Unit)
    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}