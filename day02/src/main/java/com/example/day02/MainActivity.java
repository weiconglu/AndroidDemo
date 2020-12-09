package com.example.day02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    public MainActivity() {
        Log.e("MainActivity","MainActivity created");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start1(View view) {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void start2(View view) {
        intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
