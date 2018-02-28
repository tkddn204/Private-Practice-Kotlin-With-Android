package me.ssangwoo.kotlinlecture.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import me.ssangwoo.kotlinlecture.data.source.ImageData
import me.ssangwoo.kotlinlecture.view.main.home.adapter.holder.ImageViewHolder
import me.ssangwoo.kotlinlecture.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by 쌍우 on 2018-02-27.
 */
class ImageRecyclerAdapter(private val context: Context)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel {

    private val list = mutableListOf<ImageData>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(context, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

    override fun addItem(imageData: ImageData) {
        list.add(imageData)
    }

    override fun notifyImageDataSetChange() {
        notifyDataSetChanged()
    }
}