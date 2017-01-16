package com.tyaslabs.experiment.kotlin_todo

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.Preference
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import butterknife.bindView
import com.tyaslabs.experiment.kotlin_todo.adapter.MainAdapter
import com.tyaslabs.experiment.kotlin_todo.model.Todo
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {

    val PREFS = "todo_app"
    val recyclerMain: RecyclerView by bindView(R.id.recycler_main)
    val fabButton: FloatingActionButton by bindView(R.id.fab)
    var preference : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)

        val itemList = mutableListOf<Todo>()

        val todo = Todo(0)
        todo.name = "Halo"
        todo.time = Date()
        itemList.add(todo)

        val todo1 = Todo(1)
        todo1.name = "Halo1"
        todo1.time = Date()
        itemList.add(todo1)

        recyclerMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerMain.hasFixedSize()
        recyclerMain.adapter = MainAdapter(itemList)


        fabButton.setOnClickListener { view -> startActivity(Intent(this, AddActivity::class.java)) }
    }

    override fun onStart() {
        super.onStart()
        preference = this.getSharedPreferences(PREFS, 0)
        val json = JSONArray(preference?.getString("item", ""))
    }
}
