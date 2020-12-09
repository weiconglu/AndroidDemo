package com.example.day01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.TipUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_main_msg;
    private Button btn_main_start1;
    private Button btn_main_start2;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,SecondActivity.class);

        et_main_msg = findViewById(R.id.et_main_msg);
        btn_main_start1 = findViewById(R.id.btn_main_start1);
        btn_main_start2 = findViewById(R.id.btn_main_start2);

        // 添加点击事件，让本类实现View.OnClickListener
        btn_main_start1.setOnClickListener(this);
        btn_main_start2.setOnClickListener(this);

    }

    // 哪个被点击了哪个就是v
    @Override
    public void onClick(View v) {

        if (v.equals(btn_main_start1)) {
            TipUtils.shortTips(this, "一般启动");
            // 使用信使intent在Activity之间传递数据
            String msg = et_main_msg.getText().toString();
            intent.putExtra("msg",msg);

            // 一般启动
            startActivity(intent);
        } else if (v.equals(btn_main_start2)) {
            TipUtils.shortTips(this, "带回调启动");
            // 使用信使intent在Activity之间传递数据
            String msg = et_main_msg.getText().toString();
            intent.putExtra("msg",msg);

            // 带请求Code启动
            int requestCode = 1;
            startActivityForResult(intent, requestCode);
        }

    }

    // 重写onActivityResult方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 1){
            String msgReturn = data.getStringExtra("msgReturn");
            et_main_msg.setText(msgReturn);
        }

    }

}
