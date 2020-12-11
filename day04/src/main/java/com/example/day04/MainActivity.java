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

    public void simpleComponentTest(View view) {
        startActivity(new Intent(this, SimpleComponentActivity.class));
    }

    public void menuComponentTest(View view) {
    }

    public void progressComponentTest(View view) {
    }

    public void dialogComponentTest(View view) {
    }

}
