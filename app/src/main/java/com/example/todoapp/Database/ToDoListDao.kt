package com.example.todoapp.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoListDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDoList: TodoList)

    @Delete
    suspend fun delete(toDoList: TodoList)

    @Query("Select * from list_table WHERE is_done == 0")
    fun getAllList(): LiveData<List<TodoList>>

    @Query("UPDATE list_table SET text =:newText WHERE id LIKE :txtId")
    suspend fun update(newText: String, txtId: Int)

    @Query("UPDATE list_table SET is_done =1 WHERE id LIKE :txtId")
    suspend fun markCompleted(txtId: Int)

    @Query("Select * from list_table WHERE is_done == 1")
    fun getDoneList(): Flow<List<TodoList>>
}