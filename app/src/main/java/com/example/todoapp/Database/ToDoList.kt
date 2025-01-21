package com.example.todoapp.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_table")
class TodoList(
    @ColumnInfo(name = "text") var text: String,
    @ColumnInfo(name = "is_done") var isDone: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
