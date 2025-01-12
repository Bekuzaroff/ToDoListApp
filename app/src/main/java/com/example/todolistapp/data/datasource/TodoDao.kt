package com.example.todolistapp.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todolistapp.data.models.ToDoDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToDo(toDoDbModel: ToDoDbModel)

    @Update
    suspend fun updateToDo(toDoDbModel: ToDoDbModel)

    @Delete
    suspend fun deleteToDo(toDoDbModel: ToDoDbModel)

    @Query("SELECT * FROM TODOS")
    suspend fun getAllToDos(): List<ToDoDbModel>
}