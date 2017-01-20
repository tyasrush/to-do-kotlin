package com.tyaslabs.experiment.kotlin_todo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tyaslabs.experiment.kotlin_todo.adapter.MainAdapter
import com.tyaslabs.experiment.kotlin_todo.model.Todo
import com.tyaslabs.experiment.kotlin_todo.util.TodoPreference
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONArray
import java.util.*

class MainActivity : AppCompatActivity() {

    var adapter: MainAdapter? = null
    var itemList: ArrayList<Todo>? = null
    var pref: TodoPreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)

        pref = TodoPreference(this)
        itemList = ArrayList<Todo>()


        adapter = MainAdapter(itemList)
//        val size = 10
//        for (i in 0..size) {
//            val todo = Todo(i)
//            todo.name = "Halo " + i
//            todo.time = Date()
//            itemList.add(todo)
//        }

        recycler_main.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_main.hasFixedSize()
        recycler_main.adapter = adapter

        fab.setOnClickListener { view -> startActivity(Intent(this, AddActivity::class.java)) }
    }

    override fun onStart() {
        super.onStart()
        if (pref!!.getTodos() != null) {
            if (itemList!!.size > 0)
                itemList!!.clear()

            itemList!!.addAll(pref!!.getTodos())
            adapter!!.notifyDataSetChanged()
        }
    }
}
