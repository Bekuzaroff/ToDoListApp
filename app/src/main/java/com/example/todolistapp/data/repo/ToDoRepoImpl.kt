package com.example.todolistapp.data.repo

import com.example.todolistapp.data.datasource.LocalDataSource
import com.example.todolistapp.data.mappers.DataToDomainMapper
import com.example.todolistapp.domain.models.ToDoItem
import com.example.todolistapp.domain.repo.ToDoRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepoImpl @Inject constructor(
   private val localDataSource: LocalDataSource,
   private val dataToDomainMapper: DataToDomainMapper
): ToDoRepo{
    override suspend fun insertToDo(toDoItem: ToDoItem) {
        localDataSource.insertToDo(dataToDomainMapper.itemToModelToDoMapper(toDoItem))
    }

    override suspend fun updateToDo(toDoItem: ToDoItem) {
        localDataSource.updateToDo(dataToDomainMapper.itemToModelToDoMapper(toDoItem))
    }

    override suspend fun deleteToDo(toDoItem: ToDoItem) {
        localDataSource.deleteToDo(dataToDomainMapper.itemToModelToDoMapper(toDoItem))
    }

    override suspend fun getAllToDos(): List<ToDoItem> {
        val list = localDataSource.getAllToDos()

        return list.map { model ->
            dataToDomainMapper.modelToItemToDoMapper(model)
        }
    }
}