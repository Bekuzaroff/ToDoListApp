package com.example.todolistapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.domain.mappers.FromDomainToPresMapper
import com.example.todolistapp.domain.usecases.AddToDoUseCase
import com.example.todolistapp.domain.usecases.DeleteToDoUseCase
import com.example.todolistapp.domain.usecases.GetAllToDosUseCase
import com.example.todolistapp.domain.usecases.UpdateToDoUseCase
import com.example.todolistapp.presentation.models.ToDoItemList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ToDoViewModel @Inject constructor(
    val fromDomainToPresMapper: FromDomainToPresMapper,

    val getAllToDosUseCase: GetAllToDosUseCase,
    val addToDoUseCase: AddToDoUseCase,
    val updateToDoUseCase: UpdateToDoUseCase,
    val deleteToDoUseCase: DeleteToDoUseCase
): ViewModel() {

    private val _all_todos = MutableStateFlow<List<ToDoItemList>>(listOf())

    val all_todos: Flow<List<ToDoItemList>>
        get() = _all_todos

    fun getAllToDos() = viewModelScope.launch {
        val list = getAllToDosUseCase()
        _all_todos.emit(list.map { fromDomainToPresMapper.map(it) })
    }

    fun addToDo(toDoItemList: ToDoItemList) = viewModelScope.launch {
        addToDoUseCase(fromDomainToPresMapper.fromPresToDomain(toDoItemList))
    }

    fun updateToDo(toDoItemList: ToDoItemList) = viewModelScope.launch {
        updateToDoUseCase(fromDomainToPresMapper.fromPresToDomain(toDoItemList))
    }

    fun deleteToDo(toDoItemList: ToDoItemList) = viewModelScope.launch {
        deleteToDoUseCase(fromDomainToPresMapper.fromPresToDomain(toDoItemList))
    }
}