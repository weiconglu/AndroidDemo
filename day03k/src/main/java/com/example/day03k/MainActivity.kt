package com.example.day03k

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 短按按钮进入编辑界面，长按按钮直接发送短信、拨打电话
 */
class MainActivity : AppCompatActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 添加长按监听
        btn_main_make_call.setOnLongClickListener(this)
        btn_main_send_msg.setOnLongClickListener(this)

    }

    // 短按打电话
    fun makeCall(view: View) {

    }

    // 短按发短信
    fun editMsg(view: View) {
        // 注意写法，不能直接写intent，保证此方法中的intent是同一个intent
        var intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("smsto:"+et_main_phone_number.text.toString())
        intent.putExtra("sms_body",et_main_msg.text.toString())
        startActivity(intent)
    }

    // 长按回调方法
    override fun onLongClick(v: View?): Boolean {
        if (v == btn_main_make_call){

        }
        if (v == btn_main_send_msg){

        }
        //
        return true
    }

}
