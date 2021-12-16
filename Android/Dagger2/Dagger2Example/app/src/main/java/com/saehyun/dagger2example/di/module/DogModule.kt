package com.saehyun.dagger2example.module

import com.saehyun.dagger2example.Dog
import dagger.Module
import dagger.Provides

@Module
object DogModule {

    @Provides
    fun provideDog() : Dog {
        return Dog()
    }

}