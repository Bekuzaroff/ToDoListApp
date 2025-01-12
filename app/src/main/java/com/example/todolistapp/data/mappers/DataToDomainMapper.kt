package com.example.todolistapp.data.mappers

import com.example.todolistapp.data.models.ToDoDbModel
import com.example.todolistapp.domain.models.ToDoItem

class DataToDomainMapper {
    fun modelToItemToDoMapper(
        toDoDbModel: ToDoDbModel
    ):ToDoItem{
        with(toDoDbModel){
            return ToDoItem(
                id = id,
                title = title ?: DEFAULT_TITLE,
                description = description ?: DEFAULT_DESCRIPTION
            )
        }
    }
    fun itemToModelToDoMapper(
        toDoItem: ToDoItem
    ):ToDoDbModel{
        with(toDoItem){
            return ToDoDbModel(
                id = id,
                title = title ?: DEFAULT_TITLE,
                description = description ?: DEFAULT_DESCRIPTION
            )
        }
    }
    companion object{
        const val DEFAULT_TITLE = "todo title"
        const val DEFAULT_DESCRIPTION = "todo description"
    }
}