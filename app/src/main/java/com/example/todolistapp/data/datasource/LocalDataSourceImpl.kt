package com.example.todolistapp.data.datasource

import com.example.todolistapp.data.models.ToDoDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
   private val dao: TodoDao,
): LocalDataSource {
    override suspend fun insertToDo(toDoDbModel: ToDoDbModel) {
        dao.addToDo(toDoDbModel)
    }

    override suspend fun updateToDo(toDoDbModel: ToDoDbModel) {
        dao.updateToDo(toDoDbModel)
    }

    override suspend fun deleteToDo(toDoDbModel: ToDoDbModel) {
        dao.deleteToDo(toDoDbModel)
    }

    override suspend fun getAllToDos(): List<ToDoDbModel> = dao.getAllToDos()
}