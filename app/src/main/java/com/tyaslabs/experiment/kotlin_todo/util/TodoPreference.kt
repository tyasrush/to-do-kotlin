package com.tyaslabs.experiment.kotlin_todo.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tyaslabs.experiment.kotlin_todo.model.Todo
import java.util.*

/**
 * Created by tyas on 1/20/17.
 */

class TodoPreference(context: Context?) {

    var preferences: SharedPreferences? = null
    val TODOS_LIST = "todos_list"

    init {
        preferences = context!!.getSharedPreferences("todo_app", Context.MODE_PRIVATE)
    }

    fun saveTodos(todos: ArrayList<Todo>?) {
        val gson = Gson()
        val todosJson = gson.toJson(todos)
        preferences!!.edit().putString(TODOS_LIST, todosJson).apply()
    }

    fun getTodos(): ArrayList<Todo> {
        val todosJson = preferences!!.getString(TODOS_LIST, "")
        if (todosJson != null && todosJson.length > 0)
            return Gson().fromJson(todosJson, object : TypeToken<ArrayList<Todo>>() {}.type)
        else
            return ArrayList<Todo>()
    }

}
