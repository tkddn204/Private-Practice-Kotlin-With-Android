package me.ssangwoo.kotlinlecture.data.source.image

import me.ssangwoo.kotlinlecture.data.source.ImageData

/**
 * Created by 쌍우 on 2018-02-27.
 */
object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageFileName(fileName: (String) -> Unit) {
        imageLocalData.loadImageFileName(fileName)
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        imageLocalData.loadImageList(imageDataList, size)
    }
}
