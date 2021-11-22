package com.saehyun.koinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.saehyun.koinexample.objet.Student
import com.saehyun.koinexample.objet.Teacher
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(this@MainActivity)
            modules(
                module {
                    single { Teacher("teacher-cho")
                    factory { Student("student-kim") }}
                }
            )
        }

        val teacher : Teacher by inject() // 의존성 주입
        val student : Student by inject()

        findViewById<TextView>(R.id.textViewTeacher).text = teacher.name
        findViewById<TextView>(R.id.textViewStudent).text = student.name
    }
}