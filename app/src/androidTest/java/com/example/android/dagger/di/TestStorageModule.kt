package com.example.android.dagger.di

import com.example.android.dagger.storage.Storage
import com.example.android.dagger.test.storage.FakeStorage
import dagger.Binds
import dagger.Module

@Module
abstract class TestStorageModule {

    @Binds
    abstract fun provideStorage(storage: FakeStorage): Storage
}