package com.androidatc.lesson08_e2_progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var progressBarStatus = 0
    var rate = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Downloadbutton.setOnClickListener {
            view -> Thread(Runnable {
            while (progressBarStatus < 100) {
                try {
                    rate += 10
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                progressBarStatus = rate
                progressBar.progress = progressBarStatus
            }

            progressBar.setVisibility(ProgressBar.INVISIBLE)
        }).start()
        }
    }
}
