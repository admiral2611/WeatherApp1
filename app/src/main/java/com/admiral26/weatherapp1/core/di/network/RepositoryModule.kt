package com.admiral26.weatherapp1.core.di.network

import com.admiral26.weatherapp1.core.di.repo.WeatherRepository
import com.admiral26.weatherapp1.core.di.repoImp.WeatherRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface RepositoryModule {

    @[Binds Singleton]
    fun bindWeatherRepository(repositoryImp: WeatherRepositoryImp): WeatherRepository
}