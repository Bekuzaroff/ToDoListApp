package com.example.todolistapp.data.datasource

import com.example.todolistapp.data.models.ToDoDbModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertToDo(toDoDbModel: ToDoDbModel)

    suspend fun updateToDo(toDoDbModel: ToDoDbModel)

    suspend fun deleteToDo(toDoDbModel: ToDoDbModel)

    suspend fun getAllToDos(): List<ToDoDbModel>
}