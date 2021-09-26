package com.saehyun.progressbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.saehyun.progressbarexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var isStarted = false
    var progressStatus = 0
    var handler: Handler? = null
    var secondaryHandler: Handler? = Handler()
    var primaryProgressStatus = 0
    var secondaryProgressStatus = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        handler = Handler(Handler.Callback {
            if (isStarted) {
                progressStatus++
            }
            progressBarHorizontal.progress = progressStatus
            textViewHorizontalProgress.text = "${progressStatus}/${progressBarHorizontal.max}"
            handler?.sendEmptyMessageDelayed(0, 100)

            true
        })

        handler?.sendEmptyMessage(0)


        btnProgressBarSecondary.setOnClickListener {
            primaryProgressStatus = 0
            secondaryProgressStatus = 0

            Thread(Runnable {
                while (primaryProgressStatus < 100) {
                    primaryProgressStatus += 1

                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    startSecondaryProgress()
                    secondaryProgressStatus = 0

                    secondaryHandler?.post {
                        progressBarSecondary.progress = primaryProgressStatus
                        textViewPrimary.text = "Complete $primaryProgressStatus% of 100"

                        if (primaryProgressStatus == 100) {
                            textViewPrimary.text = "All tasks completed"
                        }
                    }
                }
            }).start()
        }

    }

    fun startSecondaryProgress() {
        Thread(Runnable {
            while (secondaryProgressStatus < 100) {
                secondaryProgressStatus += 1

                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                secondaryHandler?.post {
                    progressBarSecondary.setSecondaryProgress(secondaryProgressStatus)
                    textViewSecondary.setText("Current task progress\n$secondaryProgressStatus% of 100")

                    if (secondaryProgressStatus == 100) {
                        textViewSecondary.setText("Single task complete.")
                    }
                }
            }
        }).start()
    }

    fun horizontalDeterminate(view: View) {
        isStarted = !isStarted
    }

}