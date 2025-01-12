package com.example.todolistapp.domain.mappers

import com.example.todolistapp.domain.models.ToDoItem
import com.example.todolistapp.presentation.models.ToDoItemList

class FromDomainToPresMapper {

    fun map(toDoItem: ToDoItem): ToDoItemList{
        with(toDoItem){
            return ToDoItemList(
                id = id,
                title = title ?: DEFAULT_TITLE,
                description = description ?: DEFAULT_DESCRIPTION
            )
        }
    }

    fun fromPresToDomain(toDoItemList: ToDoItemList): ToDoItem{
        with(toDoItemList){
            return ToDoItem(
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