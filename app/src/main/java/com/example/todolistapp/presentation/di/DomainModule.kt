package com.example.todolistapp.presentation.di

import androidx.room.Delete
import com.example.todolistapp.data.datasource.LocalDataSource
import com.example.todolistapp.data.mappers.DataToDomainMapper
import com.example.todolistapp.data.repo.ToDoRepoImpl
import com.example.todolistapp.domain.mappers.FromDomainToPresMapper
import com.example.todolistapp.domain.repo.ToDoRepo
import com.example.todolistapp.domain.usecases.AddToDoUseCase
import com.example.todolistapp.domain.usecases.DeleteToDoUseCase
import com.example.todolistapp.domain.usecases.GetAllToDosUseCase
import com.example.todolistapp.domain.usecases.UpdateToDoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideToDoRepo(
        localDataSource: LocalDataSource,
        dataToDomainMapper: DataToDomainMapper
    ): ToDoRepo = ToDoRepoImpl(localDataSource, dataToDomainMapper)

    @Provides
    @Singleton
    fun provideUpdateToDoUseCase(repo: ToDoRepo): UpdateToDoUseCase = UpdateToDoUseCase(repo)

    @Provides
    @Singleton
    fun provideDeleteToDoUseCase(repo: ToDoRepo): DeleteToDoUseCase = DeleteToDoUseCase(repo)

    @Provides
    @Singleton
    fun provideGetAllToDosUseCase(repo: ToDoRepo): GetAllToDosUseCase = GetAllToDosUseCase(repo)


    @Provides
    @Singleton
    fun provideFromDomainToPresMapper(): FromDomainToPresMapper = FromDomainToPresMapper()

}