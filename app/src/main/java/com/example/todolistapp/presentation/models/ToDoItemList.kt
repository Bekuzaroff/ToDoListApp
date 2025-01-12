package com.example.todolistapp.presentation.models

import java.io.Serializable


data class ToDoItemList (
    val id: Int = 0,
    val title: String ?= null,
    val description: String ?= null
): Serializable