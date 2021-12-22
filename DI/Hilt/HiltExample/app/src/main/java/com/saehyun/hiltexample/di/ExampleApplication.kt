package com.saehyun.hiltexample.di

import android.app.Application
import android.content.res.Configuration
import android.media.VolumeShaper
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ExampleApplication : Application()