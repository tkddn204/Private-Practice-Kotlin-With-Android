package me.ssangwoo.kotlinlecture.view.main.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by 쌍우 on 2018-02-27.
 */
class RecyclerViewSimpleAdapter(val context: Context):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            // ...
        }
        return SimpleViewHolder(context, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as? SimpleViewHolder)?.bindView(list[position])
    }

    fun addItem(item: String) {
        list.add(item)
    }
}