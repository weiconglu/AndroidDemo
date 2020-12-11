package com.example.day04;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.StringUtils;
import com.example.mylibrary.TipUtils;

import static android.R.drawable.alert_dark_frame;
import static android.R.drawable.alert_light_frame;
import static android.R.drawable.ic_media_pause;
import static android.R.drawable.ic_media_play;

public class SimpleComponentActivity extends AppCompatActivity {

    private TextView tv_simple;
    private EditText et_simple;
    private ImageView iv_simple_component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_component);

        tv_simple = findViewById(R.id.tv_simple);
        tv_simple.setText("简单常见组件测试");

        et_simple = findViewById(R.id.et_simple);
        iv_simple_component = findViewById(R.id.iv_simple_component);

        // 设置ImageView的前景和背景
        iv_simple_component.setOnClickListener(new View.OnClickListener() {
            int i = 0; // 设定计数来确定是切换播放/暂停

            @Override
            public void onClick(View v) {
                if (i % 2 == 0) {
                    // 更换背景及前景，这前景设置的方式有点儿怪
                    iv_simple_component.setBackgroundResource(alert_light_frame);
                    iv_simple_component.setImageResource(ic_media_pause);
                } else {
                    iv_simple_component.setBackgroundResource(alert_dark_frame);
                    iv_simple_component.setImageResource(ic_media_play);
                }
                i++;
            }
        });

    }

    public void submit(View view) {
        TipUtils.shortTips(this, et_simple.getText().toString());
        et_simple.setText("");
    }

    // 多选监听方法
    public void confirm(View view) {

        CheckBox cb_simple_basketball = findViewById(R.id.cb_simple_basketball);
        CheckBox cb_simple_football = findViewById(R.id.cb_simple_football);
        CheckBox cb_simple_ping_pong_ball = findViewById(R.id.cb_simple_ping_pong_ball);

        String msg = "";
        if (cb_simple_basketball.isChecked()) {
            msg += cb_simple_basketball.getText() + " ";
        }
        if (cb_simple_football.isChecked()) {
            msg += cb_simple_football.getText() + " ";
        }
        if (cb_simple_ping_pong_ball.isChecked()) {
            msg += cb_simple_ping_pong_ball.getText() + " ";
        }
        msg = msg.trim();
        if (StringUtils.isNotEmpty(msg)) {
            TipUtils.shortTips(this, msg);
        }else{
            TipUtils.shortTips(this, "没啥爱好");
        }

    }
}