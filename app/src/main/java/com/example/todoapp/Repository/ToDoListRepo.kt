package com.example.todoapp.Repository

import androidx.lifecycle.LiveData
import com.example.todoapp.Database.ToDoListDao
import com.example.todoapp.Database.TodoList
import kotlinx.coroutines.flow.Flow

class ToDoListRepo(private val todolistDao: ToDoListDao) {
    val allToDoList: LiveData<List<TodoList>> = todolistDao.getAllList()

    suspend fun insert(todolist: TodoList) {
        todolistDao.insert(todolist)
    }

    suspend fun delete(todolist: TodoList) {
        todolistDao.delete(todolist)
    }

    suspend fun update(newText: String, txtId: Int) {

        todolistDao.update(newText, txtId)
    }

    suspend fun markCompleted(txtId: Int) {

        todolistDao.markCompleted(txtId)
    }

    fun getDoneList(): Flow<List<TodoList>> = todolistDao.getDoneList()
}