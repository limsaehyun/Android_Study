package com.saehyun.kakaoauthexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import java.security.NoSuchAlgorithmException

import java.security.MessageDigest

import android.content.pm.PackageManager

import android.content.pm.PackageInfo
import android.content.pm.PackageManager.NameNotFoundException
import android.util.Base64


class MainActivity : AppCompatActivity() {
    companion object {
        var appContext : Context? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getHashKey()
    }

    private fun getHashKey() {
        var packageInfo: PackageInfo? = null
        try {
            packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }
        if (packageInfo == null) Log.e("KeyHash", "KeyHash:null")
        for (signature in packageInfo!!.signatures) {
            try {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            } catch (e: NoSuchAlgorithmException) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=$signature", e)
            }
        }
    }

}