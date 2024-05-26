package com.example.todoapp.Activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.Adapter.IListRvAdapter
import com.example.todoapp.Adapter.RvAdapter
import com.example.todoapp.Database.TodoList
import com.example.todoapp.Fragments.CompletedFragment
import com.example.todoapp.Fragments.ToDoFragment
import com.example.todoapp.R
import com.example.todoapp.ViewModel.MainViewModel
import com.example.todoapp.ViewModel.MainViewModelFactory
import com.example.todoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ToDoFragment())
       binding.bottomNav.setOnItemSelectedListener {
           when(it.itemId)
           {
               R.id.bottom_nav_todos -> replaceFragment(ToDoFragment())
               R.id.bottom_nav_completed -> replaceFragment(CompletedFragment())
               else -> {
                   Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
               }
           }
           return@setOnItemSelectedListener true

       }
    }
    fun replaceFragment(newFragment:Fragment)
    {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,newFragment)
        transaction.commit()
    }


}