package com.example.day01k

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 一般启动
    fun start1(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("msg", et_main_msg.text.toString())
        startActivity(intent)
    }

    fun start2(view: View) {
        var intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("msg", et_main_msg.text.toString())
        startActivityForResult(intent, 1)
    }

    // 重写onActivityResult方法，以响应返回时的操作
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // 如果请求id和结果id为指定值，则执行此方法
        if (requestCode == 1 && resultCode == 1){
            et_main_msg.setText(data?.getStringExtra("msg"))
        }

    }

}
