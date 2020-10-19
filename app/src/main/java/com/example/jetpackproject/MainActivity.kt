package com.example.jetpackproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val constraints: Constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()

        val uploadWorkRequest = OneTimeWorkRequest.Builder(TestWorker::class.java)
                .setConstraints(constraints) //设置触发条件
                .build()

        WorkManager.getInstance(this).enqueue(uploadWorkRequest);
    }
}