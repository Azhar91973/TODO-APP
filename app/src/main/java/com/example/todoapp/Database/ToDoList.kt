package com.example.todoapp.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_table")
class TodoList(@ColumnInfo(name = "text") var text: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
