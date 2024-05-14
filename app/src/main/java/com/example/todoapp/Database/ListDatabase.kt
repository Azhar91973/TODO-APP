package com.example.todoapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoList::class], version = 1, exportSchema = false)
abstract class ListDatabase : RoomDatabase() {

    abstract fun getTodoListDao(): ToDoListDao

    companion object{
        @Volatile
         private var Instance : ListDatabase?=null

        fun getdatabase(context: Context): ListDatabase {
            return Instance ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ListDatabase::class.java,
                    "list_table"
                ).build()
                Instance =instance
                instance
            }
        }
    }
}
