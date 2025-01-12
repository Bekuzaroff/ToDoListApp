package com.example.todolistapp.domain.models

data class ToDoItem(
    val id: Int = 0,
    val title: String ?= null,
    val description: String ?= null
)
