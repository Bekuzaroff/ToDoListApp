package com.example.todolistapp.domain.repo

import com.example.todolistapp.data.models.ToDoDbModel
import com.example.todolistapp.domain.models.ToDoItem

interface ToDoRepo {
    suspend fun insertToDo(toDoItem: ToDoItem)

    suspend fun updateToDo(toDoItem: ToDoItem)

    suspend fun deleteToDo(toDoItem: ToDoItem)

    suspend fun getAllToDos(): List<ToDoItem>
}