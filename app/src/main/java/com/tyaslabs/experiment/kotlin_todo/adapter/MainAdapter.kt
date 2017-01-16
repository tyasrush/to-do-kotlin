package com.tyaslabs.experiment.kotlin_todo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tyaslabs.experiment.kotlin_todo.R
import com.tyaslabs.experiment.kotlin_todo.model.Todo
import kotlinx.android.synthetic.main.item_todo.view.*

/**
 * Created by tyas on 1/16/17.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private val itemList : MutableList<Todo>

    constructor(itemList: MutableList<Todo>?) : super() {
        this.itemList = itemList!!
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindTodo(itemList.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_todo, parent, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTodo(todo: Todo) {
            itemView.tv_title.text = todo.name
            itemView.tv_subtitle.text = todo.time.toString()
        }
    }

}