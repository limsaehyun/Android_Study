package com.saehyun.koinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.saehyun.koinexample.objet.Student
import com.saehyun.koinexample.objet.Teacher
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidContext(this@MainActivity)
            modules(
                module {
                    single(named("cho")) { Student("student-cho") }
                    single(named("kim")) { Student("student-kim") }
                    factory { Teacher("teacher-cho") }
                }
            )
        }

        val teacher : Teacher by inject() // 의존성 주입

        val studentCho : Student by inject(named("cho"))
        val studentKim : Student by inject(named("kim"))

        findViewById<TextView>(R.id.textViewTeacher).text = teacher.name

        findViewById<TextView>(R.id.textViewStudent).text = studentCho.name
        findViewById<TextView>(R.id.textViewStudent).text = studentKim.name
    }
}