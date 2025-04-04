package com.example.mviapp.di

import com.example.mviapp.data.repository.FavoriteRepository
import com.example.mviapp.data.repository.RecipeRepository
import com.example.mviapp.data.repository.UserRepository
import com.example.mviapp.presentation.screens.favorite.FavoriteHandler
import com.example.mviapp.presentation.screens.home.RecipeHandler
import com.example.mviapp.presentation.screens.settings.SettingsHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return UserRepository()
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(): RecipeRepository {
        return RecipeRepository()
    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(): FavoriteRepository {
        return FavoriteRepository()
    }

    @Provides
    @Singleton
    fun provideRecipeHandler(recipeRepository: RecipeRepository): RecipeHandler {
        return RecipeHandler(recipeRepository)
    }

    @Provides
    @Singleton
    fun provideFavoriteHandler(favoriteRepository: FavoriteRepository): FavoriteHandler {
        return FavoriteHandler(favoriteRepository)
    }

    @Provides
    @Singleton
    fun provideSettingsHandler(): SettingsHandler {
        return SettingsHandler(userRepository = UserRepository())
    }
}