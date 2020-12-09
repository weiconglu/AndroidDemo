package com.example.day03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.TipUtils;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private Intent intent;
    private SmsManager smsManager;
    // 组件
    private EditText et_main_phone_number;
    private EditText et_main_msg;
    private Button btn_main_make_call;
    private Button btn_main_send_msg;

    // 数据
    private String phoneNumber;
    private String msgText;
    private String action;
    private Uri data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main_phone_number = findViewById(R.id.et_main_phone_number);
        et_main_msg = findViewById(R.id.et_main_msg);
        btn_main_make_call = findViewById(R.id.btn_main_make_call);
        btn_main_send_msg = findViewById(R.id.btn_main_send_msg);

        // 添加长按回调方法
        btn_main_make_call.setOnLongClickListener(this);
        btn_main_send_msg.setOnLongClickListener(this);
    }

    // 点击“打电话”button进入拨号界面
    public void makeCall(View view) {
        phoneNumber = et_main_phone_number.getText().toString();
        action = Intent.ACTION_DIAL;
        data = Uri.parse("tel: " + phoneNumber);  // 注意Uri data的写法
        intent = new Intent(action);
        intent.setData(data);
        startActivity(intent);
    }

    // 点击“发短信”button进入短信编辑界面
    public void editMsg(View view) {
        phoneNumber = et_main_phone_number.getText().toString();
        msgText = et_main_msg.getText().toString();
        action = Intent.ACTION_SENDTO;
        // 携带数据（号码、短信内容）
        data = Uri.parse("smsto: " + phoneNumber);
        intent = new Intent(action);
        intent.setData(data);
        intent.putExtra("sms_body", msgText);
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(View v) {

        if (v.equals(btn_main_make_call)) {
            phoneNumber = et_main_phone_number.getText().toString();
            action = Intent.ACTION_CALL; //android.intent.action.CALL
            data = Uri.parse("tel: " + phoneNumber);
            intent = new Intent(action);
            intent.setData(data);
            startActivity(intent);
        }
        if (v.equals(btn_main_send_msg)) {
            phoneNumber = et_main_phone_number.getText().toString();
            msgText = et_main_msg.getText().toString();
            smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, msgText, null, null);
            TipUtils.shortTips(MainActivity.this, "短信已发送");
        }

        // 如果给View设置了OnClickListener和OnLongClickListener两个点击监听器，长按被解发时是否不触发短按(true不触发，false触发)
        // 返回true表示此长按事件已经被消费了，不会再触发点击事件
        return true;
    }

}
