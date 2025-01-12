package com.example.todolistapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class ToDoDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String ?= null,
    val description: String ?= null
)
