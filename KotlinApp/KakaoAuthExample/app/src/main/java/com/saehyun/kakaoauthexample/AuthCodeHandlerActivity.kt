package com.saehyun.kakaoauthexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AuthCodeHandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_code_handler)

        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패", error)
            }
            else if (token != null) {
                Log.i(TAG, "로그인 성공 ${token.accessToken}")
            }
        }


    }
}