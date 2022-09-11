package com.example.bankuishchallenge.di

import com.example.bankuishchallenge.framework.datasource.ReposDaoImp
import com.example.data.dao.ReposDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindReposDao(imp: ReposDaoImp): ReposDao

}