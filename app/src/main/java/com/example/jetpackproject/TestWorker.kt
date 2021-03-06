package com.example.jetpackproject

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class TestWorker(val context: Context, val params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {

        return Result.success()
    }
}