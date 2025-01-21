package com.example.todoapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.Activity.UpdateDialog
import com.example.todoapp.Adapter.RvAdapter
import com.example.todoapp.Database.TodoList
import com.example.todoapp.ViewModel.MainViewModel
import com.example.todoapp.ViewModel.MainViewModelFactory
import com.example.todoapp.databinding.FragmentToDoBinding


class ToDoFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentToDoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentToDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.layoutManager = LinearLayoutManager(context)
        val adapter =
            RvAdapter(requireContext(), ::deleteToDo, ::updateToDo, ::markCompleted, false)
        binding.rv.adapter = adapter

        val viewModelFactory = MainViewModelFactory(requireActivity().application)
        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        mainViewModel.allList.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
        binding.addToDos.setOnClickListener {
            submitToDo()
        }
    }

    private fun deleteToDo(item: TodoList) {
        mainViewModel.delete(item)
        Toast.makeText(requireContext(), "${item.text} Deleted", Toast.LENGTH_SHORT).show()
    }

    private fun markCompleted(item: TodoList) {
        mainViewModel.markCompleted(item.id)
    }

    private fun updateToDo(item: TodoList) {
        item.text = item.text.trim()
        UpdateDialog.showDialog(requireContext(), item.text) { updatedText ->
            // Handle the updated text
            if (updatedText.isNotEmpty()) {
                if (updatedText != item.text) {
                    mainViewModel.update(updatedText, item.id)
                    Toast.makeText(requireContext(), "${item.text} Updated", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun submitToDo() {
        val todo = binding.inputTodo.text.toString()
        binding.inputTodo.text.clear()
        binding.inputTodo.clearFocus()
        val foundItem = mainViewModel.allList.value?.find { it.text == todo }
        if (foundItem?.text == null && todo.isNotEmpty()) {
            mainViewModel.insert(TodoList(todo))
            Toast.makeText(requireContext(), "$todo Inserted", Toast.LENGTH_SHORT).show()
        } else if (foundItem?.text != null) {
            Toast.makeText(requireContext(), "Todo Already Exists", Toast.LENGTH_SHORT).show()
        }
    }


}