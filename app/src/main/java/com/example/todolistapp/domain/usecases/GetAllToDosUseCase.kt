package com.example.todolistapp.domain.usecases

import com.example.todolistapp.domain.models.ToDoItem
import com.example.todolistapp.domain.repo.ToDoRepo
import javax.inject.Inject

class GetAllToDosUseCase @Inject constructor(
    private val repo: ToDoRepo
) {

    suspend operator fun invoke(): List<ToDoItem>{
        return repo.getAllToDos()
    }
}