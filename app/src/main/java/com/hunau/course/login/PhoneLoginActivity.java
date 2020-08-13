package com.hunau.course.login;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hunau.course.R;

public class PhoneLoginActivity extends Activity {

    private ImageButton phone_login_back;  // 定义左上角返回按钮
    private TextView severItems; // 服务条款文本

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
        // 获取登录界面各个组件
        initView();
        // 为每个按钮设置监听器
        initBtnEvent();
    }

    private void initBtnEvent() {
        /**
         * 短信验证码界面的左上角返回图标，提交按钮，获取验证码按钮 设置同一个监听器对象
         * 采用switch来判断用户选择哪一个功能
         */
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    // 如果点击左上角返回图标,返回到登录界面
                    case R.id.phone_login_back:
                        Intent intent = new Intent(PhoneLoginActivity.this, LoginActivity.class);
                        // 跳转时清除当前这个栈，从新建一个栈，新的界面在这个新栈里打开
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                }
            }
        };
        // 设置相应的监听器
        phone_login_back.setOnClickListener(listener); // 左上角返回图标设置监听器
    }

    private void initView() {

        phone_login_back = findViewById(R.id.phone_login_back); // 获取左上角返回图标
        severItems = findViewById(R.id.sever_items); // 获取服务条款文本
    }
}
