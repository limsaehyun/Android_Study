package com.saehyun.dsmauth

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.semicolon.dsm_sdk_v1.DTOtoken
import com.semicolon.dsm_sdk_v1.DTOuser
import com.semicolon.dsm_sdk_v1.DsmSdk

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val instance = DsmSdk.instance

        instance.initSDK(
            "DSM_Auth_Test",
            "Secret_Test",
            "https://dsmauthtest.com/oauth"
        )

        val loginCallBack : (DTOuser?) -> Unit = {
            Log.i(TAG, "사용자 정보" +
                    "\n이름 : ${it?.name} " +
                    "\n이메일 : ${it?.email}" +
                    "\n학번 : ${it?.gcn}")
        }

        val tokenCallback: (DTOtoken?, Throwable?) -> Unit = { token, error ->    // 토큰을 받아왔을때의 콜백메서드
            if (error != null) {
                Log.e("로그인 실패", error.toString())
            } else if (token != null) {
                val accessToken = token.access_token   // access토큰
                val refreshToken = token.refresh_token // refresh토큰
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            }
        }

        instance.loginWithAuth(this, tokenCallback, loginCallBack)

    }
}