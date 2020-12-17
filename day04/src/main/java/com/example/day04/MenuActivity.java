package com.example.day04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mylibrary.TipUtils;

public class MenuActivity extends AppCompatActivity {

    private Button btn_context_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_context_menu = findViewById(R.id.btn_context_menu);
        // 添加长按创建上下文菜单监听
        btn_context_menu.setOnCreateContextMenuListener(this);
    }

    //--------------------------------------------------ContextMenu----------------------------------------------------------------------------
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, 1, Menu.NONE, "添加3");
        menu.add(Menu.NONE, 2, Menu.NONE, "删除3");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        TipUtils.shortTips(this, item.getTitle().toString());
        return super.onContextItemSelected(item);
    }
    //--------------------------------------------------ContextMenu----------------------------------------------------------------------------

    //--------------------------------------------------OptionsMenu----------------------------------------------------------------------------
    // 重写onCreateOptionsMenu方法，创建OptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, Menu.NONE, "添加1");
        menu.add(Menu.NONE, 2, Menu.NONE, "删除1");
        return super.onCreateOptionsMenu(menu);
    }

    // 重写onCreateOptionsMenu方法，创建OptionsMenu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // 通过菜单填充器，填充菜单
//        getMenuInflater().inflate(R.menu.options_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    // 重写onOptionsItemSelected方法，响应菜单选项被选中时的动作
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TipUtils.shortTips(this, item.getTitle().toString());
        return super.onOptionsItemSelected(item);
    }
    //--------------------------------------------------OptionsMenu----------------------------------------------------------------------------

}