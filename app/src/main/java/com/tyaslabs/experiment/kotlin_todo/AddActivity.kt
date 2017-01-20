package com.tyaslabs.experiment.kotlin_todo

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.tyaslabs.experiment.kotlin_todo.model.Todo
import com.tyaslabs.experiment.kotlin_todo.util.TodoPreference
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        title = "Add To Do"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initUi()
    }

    fun initUi() {
//        et_time.setOnFocusChangeListener { view, b ->
//            if (b) {
//                DatePickerDialog()
//            } else {
//
//            }
//        }

        val pref = TodoPreference(this)
        fab.setOnClickListener {
            view ->
            if (et_name.text != null && et_time.text != null && et_name.text.toString().trim().length > 0 && et_time.text.toString().trim().length > 0) {
                val todosList = ArrayList<Todo>()
                if (pref.getTodos() != null) todosList.addAll(pref.getTodos())

                val formatDate = SimpleDateFormat("ddMMyyyy", Locale.getDefault())
                val dateTodo = formatDate.parse(et_time.text.toString())
                val todo = Todo(System.currentTimeMillis().toInt())
                todo.name = et_name.text.toString()
                todo.time = dateTodo
                todosList.add(todo)
                pref.saveTodos(todosList)
                finish()
            } else {
                Snackbar.make(view, "Name dan time masih kosong", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }
}
