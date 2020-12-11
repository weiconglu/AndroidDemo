package com.example.day01k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 初始化et_second_msg
        et_second_msg.setText(intent.getStringExtra("msg").toString())

    }

    fun return1(view: View) {
        finish()
    }

    // 带结果的返回
    fun return2(view: View) {
        intent.putExtra("msg", et_second_msg.text.toString())
        setResult(1,intent)
        finish()
    }
}