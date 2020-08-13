package com.hunau.course;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hunau.course.login.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // 定义一个计时器
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // 从启动界面跳转到登陆界面
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                // 执行完就结束当前任务
                finish();
            }
        };
        // schedule 相当于创建一个线程，执行TimerTask中的任务
        timer.schedule(timerTask,2000);
    }
}
