package com.example.todolistapp.domain.usecases

import com.example.todolistapp.domain.models.ToDoItem
import com.example.todolistapp.domain.repo.ToDoRepo
import javax.inject.Inject

class UpdateToDoUseCase @Inject constructor(
   private val repo: ToDoRepo
) {

    suspend operator fun invoke(toDoItem: ToDoItem){
        repo.updateToDo(toDoItem)
    }
}