package com.saehyun.dagger2example.di

import com.saehyun.dagger2example.MainActivity
import com.saehyun.dagger2example.module.CatModule
import com.saehyun.dagger2example.module.DogModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DogModule::class, CatModule::class])
interface PetComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun build() : PetComponent

        fun dogModule(dogModule : DogModule) : Builder
        fun catModule(catModule: CatModule) : Builder


    }
}