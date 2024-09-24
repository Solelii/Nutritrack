package com.example.softwareengineeringproject.graph//package com.example.softwareengineeringproject.graph

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NutrientDataManipulationModule {

    @Binds
    @Singleton
    @Named("A")
    abstract fun bindRDA(

    )

}