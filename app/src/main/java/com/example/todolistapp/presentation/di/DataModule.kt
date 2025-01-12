package com.example.todolistapp.presentation.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.todolistapp.data.datasource.LocalDataSource
import com.example.todolistapp.data.datasource.LocalDataSourceImpl
import com.example.todolistapp.data.datasource.TodoDao
import com.example.todolistapp.data.db.ToDoBase
import com.example.todolistapp.data.mappers.DataToDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): ToDoBase{
        return Room.databaseBuilder(context,
            ToDoBase::class.java,
            name = "todo.db").build()
    }

    @Provides
    @Singleton
    fun provideDao(toDoBase: ToDoBase) = toDoBase.getDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(dao: TodoDao): LocalDataSource = LocalDataSourceImpl(dao)

    @Provides
    @Singleton
    fun provideDataToDomainMapper() = DataToDomainMapper()
}