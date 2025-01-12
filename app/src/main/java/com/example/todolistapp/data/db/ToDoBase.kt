package com.example.todolistapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolistapp.data.datasource.TodoDao
import com.example.todolistapp.data.models.ToDoDbModel

@Database(entities = [ToDoDbModel::class], version = 1)
abstract class ToDoBase(): RoomDatabase() {
    abstract fun getDao(): TodoDao

}