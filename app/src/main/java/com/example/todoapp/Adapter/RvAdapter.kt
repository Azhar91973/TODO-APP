package com.example.todoapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Database.TodoList
import com.example.todoapp.R

class RvAdapter(
    private val context: Context,
    val deleteToDo: (TodoList) -> Unit,
    val updateToDo: (TodoList) -> Unit,
    val markCompleted: (TodoList) -> Unit,
    val state: Boolean
) : RecyclerView.Adapter<RvAdapter.ListViewHolder>() {
    private val allList = ArrayList<TodoList>()

    inner class ListViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val update = itemView.findViewById<ImageView>(R.id.edit)!!
        val delete = itemView.findViewById<ImageView>(R.id.delete)!!
        val completed = itemView.findViewById<ImageView>(R.id.completed)!!
        val todotxt = itemview.findViewById<TextView>(R.id.todotxt)!!
        val idtxt = itemview.findViewById<TextView>(R.id.id_text)!!
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater =
            ListViewHolder(LayoutInflater.from(context).inflate(R.layout.listdesign, parent, false))

        layoutInflater.update.setOnClickListener {
            updateToDo(allList[layoutInflater.adapterPosition])
        }

        layoutInflater.delete.setOnClickListener {
            deleteToDo(allList[layoutInflater.adapterPosition])
        }
        layoutInflater.completed.setOnClickListener {
            markCompleted(allList[layoutInflater.adapterPosition])
        }
        return layoutInflater
    }

    override fun getItemCount(): Int {
        return allList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentList = allList[position]
        if (state) {
            holder.completed.visibility = View.GONE
            holder.update.visibility = View.GONE
        } else {
            holder.completed.visibility = View.VISIBLE
            holder.update.visibility = View.VISIBLE
        }
        holder.todotxt.text = currentList.text
        var posInt = position
        posInt += 1
        var posStr = posInt.toString()
        posStr += '.'
        holder.idtxt.text = posStr
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newlist: List<TodoList>) {
        allList.clear()
        allList.addAll(newlist)
        notifyDataSetChanged()
    }
}