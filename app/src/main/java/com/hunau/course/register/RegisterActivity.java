package com.hunau.course.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hunau.course.R;
import com.hunau.course.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private TextView severItems; // 服务条款文本
    private TextView register_login; // 注册页面登录按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // 获取每个组件
        initView();
        // 为相应按钮设置监听器
        initEvent();

    }

    private void initEvent() {
        /**
         * 注册页面的左上角登录文本，获取验证码按钮，提交按钮，服务条款文本设置同一个监听器对象
         * 采用switch来判断用户选择哪一个功能
         */
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    // 如果点击左上角“也有账号？登录” 返回登录界面
                    case R.id.register_login:
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        // 跳转时清除当前这个栈，从新建一个栈，新的界面在这个新栈里打开
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                }
            }
        };
        // 设置相应监听器
        register_login.setOnClickListener(listener); // 左上方“也有账号？登录”，设置监听器
    }

    private void initView() {
        severItems = findViewById(R.id.sever_items); // 服务条款文本
        register_login = findViewById(R.id.register_login); // 注册页面登录按钮
    }
}
