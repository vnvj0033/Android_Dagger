package com.example.android.dagger.sandbox

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [StringModule::class, ModelModule::class, SubcomponentModule::class, Sub2componentModule::class])
interface MainComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainComponent
    }

    fun subcomponentModule() : SubComponent.Factory
    fun sub2componentModule() : Sub2Component.Factory
}

@Module
class StringModule {
    @Provides
    fun providesString(): String = "PROVIDES_STRING"
}

@Module
class ModelModule {
    @Provides
    fun providesModel(string: String) = Model(string)
}

@Module(subcomponents = [SubComponent::class])
class SubcomponentModule

@Module(subcomponents = [Sub2Component::class])
class Sub2componentModule