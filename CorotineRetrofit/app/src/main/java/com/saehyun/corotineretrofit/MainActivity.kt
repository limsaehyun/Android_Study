package com.saehyun.corotineretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.lang.reflect.Array.get
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope { // CoroutineScope 인터페이스 상속

    private lateinit var job: Job // Job 객체를 선언 (코루틴 동작을 제어하기 위한 객체)

    override val coroutineContext: CoroutineContext // Dispather.Main(코루틴의 쓰레드 지정) 위에 생성한 다음 Job을 더함
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = Job()
    }

    fun onDestory() {
        super.onDestroy()

        job.cancel() // Activity가 종료될 때 수행 중인 코루틴이 있다면 모두 취소
    }
}