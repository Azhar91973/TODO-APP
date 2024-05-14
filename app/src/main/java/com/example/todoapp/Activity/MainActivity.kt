package com.example.todoapp.Activity

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.Adapter.IListRvAdapter
import com.example.todoapp.Adapter.RvAdapter
import com.example.todoapp.Database.TodoList
import com.example.todoapp.ViewModel.MainViewModel
import com.example.todoapp.ViewModel.MainViewModelFactory
import com.example.todoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), IListRvAdapter {
    private lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.layoutManager = LinearLayoutManager(this)
        val adapter = RvAdapter(this, this)
        binding.rv.adapter = adapter

        val viewModelFactory = MainViewModelFactory(application)
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.allList.observe(this, Observer {
            if (it != null) {
                adapter.updateList(it)
            }
        })
    }

    fun submitToDo(view: View) {
        val todo = binding.inputTodo.text.toString()
        binding.inputTodo.text.clear()
        binding.inputTodo.clearFocus()
        val foundItem = mainViewModel.allList.value?.find { it.text == todo }
        if(foundItem?.text == null  && todo.isNotEmpty())
        {
            mainViewModel.insert(TodoList(todo))
            Toast.makeText(this, "$todo Inserted", Toast.LENGTH_SHORT).show()
        }
        else if(foundItem?.text != null){
            Toast.makeText(this, "Todo Already Exists", Toast.LENGTH_SHORT).show()
        }
    }

    override fun deleteToDo(item: TodoList) {
        mainViewModel.delete(item)
        Toast.makeText(this, "${item.text} Deleted", Toast.LENGTH_SHORT).show()
    }

    override fun updateToDo(item: TodoList) {
        UpdateDialog.showDialog(this, item.text) { updatedText ->
            // Handle the updated text
            if(updatedText.isNotEmpty())
            {
                if(updatedText != item.text)
                {
                    mainViewModel.update(updatedText, item.id)
                    Toast.makeText(this, "${item.text} Updated", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}