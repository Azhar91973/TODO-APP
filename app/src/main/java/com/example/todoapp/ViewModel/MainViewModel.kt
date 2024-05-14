package com.example.todoapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todoapp.Database.ListDatabase
import com.example.todoapp.Repository.ToDoListRepo
import com.example.todoapp.Database.TodoList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val application: Application) : AndroidViewModel(application) {


    private val repository: ToDoListRepo
     val allList: LiveData<List<TodoList>>

    init {
        val listDao = ListDatabase.getdatabase(application).getTodoListDao()
        repository = ToDoListRepo(listDao)
        allList = repository.allToDoList
    }

    fun insert(todoList: TodoList) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(todoList)
        }
    }

    fun delete(todoList: TodoList) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(todoList)
        }
    }

    fun update(newText: String, id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(newText,id)
        }
    }

}
