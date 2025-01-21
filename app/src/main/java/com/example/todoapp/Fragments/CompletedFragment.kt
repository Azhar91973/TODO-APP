package com.example.todoapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.Adapter.RvAdapter
import com.example.todoapp.Database.TodoList
import com.example.todoapp.ViewModel.MainViewModel
import com.example.todoapp.databinding.FragmentCompletedBinding
import kotlinx.coroutines.launch

class CompletedFragment : Fragment() {
    private lateinit var binding: FragmentCompletedBinding
    private lateinit var viewModel: MainViewModel
    private var adapter: RvAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompletedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setUpRv()
        getCompletedToDo()
    }

    private fun getCompletedToDo() {
        lifecycleScope.launch {
            viewModel.getDoneList().collect {
                adapter?.updateList(it)
            }
        }
    }

    private fun setUpRv() {
        binding.rvCompletedTodo.layoutManager = LinearLayoutManager(requireContext())
        adapter = RvAdapter(requireContext(), ::deleteTodo, ::updateToDo, ::markCompleted, true)
        binding.rvCompletedTodo.adapter = adapter
    }

    private fun markCompleted(item: TodoList){}

    private fun updateToDo(item: TodoList){}

    private fun deleteTodo(item: TodoList) {
        viewModel.delete(item)
    }
}