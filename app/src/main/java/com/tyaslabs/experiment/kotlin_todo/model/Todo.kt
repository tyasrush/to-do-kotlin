package com.tyaslabs.experiment.kotlin_todo.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by tyas on 1/16/17.
 */
data class Todo(val value: Int) : Parcelable {

    var id: Int = 0
    var name: String = ""
    var time: Date = Date()

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Todo> = object : Parcelable.Creator<Todo> {
            override fun createFromParcel(source: Parcel): Todo = Todo(source)
            override fun newArray(size: Int): Array<Todo?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readInt())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(value)
    }
}