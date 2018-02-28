package me.ssangwoo.kotlinlecture.view.main.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*
import me.ssangwoo.kotlinlecture.R

/**
 * Created by 쌍우 on 2018-02-27.
 */
class SimpleViewHolder(context: Context, parent: ViewGroup?):
        RecyclerView.ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_list, parent, false)){

    fun bindView(item: String?) {
        itemView.bindView(item)
    }

    fun View.bindView(item: String?) {
        tv_message.text = item ?: ""
    }

}