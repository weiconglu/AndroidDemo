package com.example.day04;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylibrary.StringUtils;
import com.example.mylibrary.TipUtils;

import static android.R.drawable.alert_dark_frame;
import static android.R.drawable.alert_light_frame;
import static android.R.drawable.ic_media_pause;
import static android.R.drawable.ic_media_play;

public class SimpleComponentActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private TextView tv_simple;
    private EditText et_simple;
    private ImageView iv_simple;

    private CheckBox cb_simple_basketball;
    private CheckBox cb_simple_football;
    private CheckBox cb_simple_ping_pong_ball;

    private RadioGroup rg_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_component);

        tv_simple = findViewById(R.id.tv_simple);
        tv_simple.setText("简单常见组件测试");

        et_simple = findViewById(R.id.et_simple);
        iv_simple = findViewById(R.id.iv_simple);

        // 设置ImageView的前景和背景
        iv_simple.setOnClickListener(new View.OnClickListener() {
            int i = 0; // 设定计数来确定是切换播放/暂停

            @Override
            public void onClick(View v) {
                if (i % 2 == 0) {
                    // 更换背景及前景，这前景设置的方式有点儿怪
                    iv_simple.setBackgroundResource(alert_light_frame);
                    iv_simple.setImageResource(ic_media_pause);
                } else {
                    iv_simple.setBackgroundResource(alert_dark_frame);
                    iv_simple.setImageResource(ic_media_play);
                }
                i++;
            }
        });

        cb_simple_basketball = findViewById(R.id.cb_simple_basketball);
        cb_simple_football = findViewById(R.id.cb_simple_football);
        cb_simple_ping_pong_ball = findViewById(R.id.cb_simple_ping_pong_ball);

        cb_simple_basketball.setOnCheckedChangeListener(this);
        cb_simple_football.setOnCheckedChangeListener(this);
        cb_simple_ping_pong_ball.setOnCheckedChangeListener(this);

        rg_gender = findViewById(R.id.rg_gender);
        rg_gender.setOnCheckedChangeListener(this);

    }

    // 提交按钮的监听方法
    public void submit(View view) {
        TipUtils.shortTips(this, et_simple.getText().toString());
        et_simple.setText("");
    }

    // CheckBox监听方法
    public void confirm(View view) {
        StringBuilder sb = new StringBuilder();
        if (cb_simple_basketball.isChecked()) {
            sb.append(cb_simple_basketball.getText() + " ");
        }
        if (cb_simple_football.isChecked()) {
            sb.append(cb_simple_football.getText() + " ");
        }
        if (cb_simple_ping_pong_ball.isChecked()) {
            sb.append(cb_simple_ping_pong_ball.getText());
        }
        String msg = new String(sb);
        if (StringUtils.isNotEmpty(msg)) {
            TipUtils.shortTips(this, msg);
        } else {
            TipUtils.shortTips(this, "没啥爱好");
        }
    }

    // 多选框各个选项被选状态改变时的监听方法
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.equals(cb_simple_basketball) || buttonView.equals(cb_simple_football) || buttonView.equals(cb_simple_ping_pong_ball)) {
            if (isChecked) {
                TipUtils.shortTips(this, buttonView.getText().toString() + "被选中了");
            } else {
                TipUtils.shortTips(this, buttonView.getText().toString() + "被取消选中了");
            }
        }
    }

    // 单选组监听方法
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton radioButton = findViewById(checkedId);
        if (group.equals(rg_gender)) {
            TipUtils.shortTips(this, radioButton.getText().toString());
        }
    }

}