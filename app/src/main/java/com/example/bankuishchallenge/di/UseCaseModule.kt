package com.example.bankuishchallenge.di

import com.example.data.dao.ReposDao
import com.example.usecases.MainCase
import com.example.usecases.ReposListCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providerMainCase(
    ): MainCase {
        return MainCase(
        )
    }

    @Singleton
    @Provides
    fun providerReposListCase(
        reposDao: ReposDao
    ): ReposListCase {
        return ReposListCase(
            reposDao = reposDao
        )
    }
}

