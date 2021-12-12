package com.saehyun.dagger2example.module

import com.saehyun.dagger2example.Cat
import dagger.Module
import dagger.Provides

@Module
object CatModule {

    @Provides
    fun provideCat() : Cat {
        return Cat()
    }

}