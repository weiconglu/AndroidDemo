package com.example.day04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // 测试常用简单的Component
    public void simpleComponentTest(View view) {
        startActivity(new Intent(this, SimpleComponentActivity.class));
    }

    // 测试菜单Component
    public void menuComponentTest(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    // 测试进度条Component
    public void progressComponentTest(View view) {
    }

    // 测试对话框Component
    public void dialogComponentTest(View view) {
    }

}
