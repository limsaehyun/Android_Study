package com.saehyun.dagger2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.saehyun.dagger2example.di.DaggerPetComponent
import com.saehyun.dagger2example.module.CatModule
import com.saehyun.dagger2example.module.DogModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cat: Cat

    @Inject
    lateinit var dog: Dog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerPetComponent.builder()
            .catModule(CatModule)
            .dogModule(DogModule)
            .build()
            .inject(this)

        Log.d("Main", "onCreate: ${dog.getDogName() + cat.getCatName()}")
    }
}