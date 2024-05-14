package com.example.todoapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoListDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDoList: TodoList)

    @Delete
    suspend fun delete(toDoList: TodoList)

    @Query("Select * from list_table order by id ASC")
    fun getAllList(): LiveData<List<TodoList>>

    @Query("UPDATE list_table SET text =:newText WHERE id LIKE :txtId" )
    suspend fun update(newText:String,txtId:Int)
}