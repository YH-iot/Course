package com.hunau.course.forgetpwd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.hunau.course.R;
import com.hunau.course.login.LoginActivity;

public class ForgetPassWordActivity extends AppCompatActivity {

    private ImageButton forget_pwd_back; // 定义左上角返回按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        // 获取每个组件
        initView();
        // 为相应按钮设置监听器
        initEvent();
    }

    private void initEvent() {
        /**
         * 忘记密码界面的左上角返回图标，提交按钮，获取验证码按钮 设置同一个监听器对象
         * 采用switch来判断用户选择哪一个功能
         */
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    // 如果点击左上角返回图标,返回到登录界面
                    case R.id.forget_pwd_back:
                        Intent intent = new Intent(ForgetPassWordActivity.this, LoginActivity.class);
                        // 跳转时清除当前这个栈，从新建一个栈，新的界面在这个新栈里打开
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                }
            }
        };
        // 设置相应的监听器
        forget_pwd_back.setOnClickListener(listener); // // 左上角返回图标设置监听器
    }

    private void initView() {
        forget_pwd_back = findViewById(R.id.forget_pwd_back); // 获取左上角返回按钮
    }
}
