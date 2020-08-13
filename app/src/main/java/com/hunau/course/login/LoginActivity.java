package com.hunau.course.login;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hunau.course.R;
import com.hunau.course.forgetpwd.ForgetPassWordActivity;
import com.hunau.course.register.RegisterActivity;

public class LoginActivity extends Activity {

    private Button verifyCode_login;
    private EditText et_pwd; // 密码输入框
    private ImageView pwd_visible; // 保存密码可见或不可见的图片
    private boolean isHidden = true; // 保存密码显示状态，初始为false，不显示密码
    private Button register; // 注册按钮
    private TextView pwd_forget; // 忘记密码按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 获取登录界面各个组件
        initView();
        // 为每个按钮设置监听器
        initBtnEvent();
    }

    private void initBtnEvent() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 如果是普通按钮
                switch (view.getId()){
                    case R.id.verifyCode_login:
                        // 单击了短信验证码登录按钮，跳转到验证码登录界面
                        startActivity(new Intent(LoginActivity.this,PhoneLoginActivity.class));
                        break;
                        // 设置密码可见或不可见
                    case R.id.pwd_visible:
                        if(isHidden){
                            // 设置密码框为可见
                            et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            // 设置显示图片为可见
                            pwd_visible.setImageResource(R.drawable.pwd_visible);
                        }else {
                            // 设置密码框不可见
                            et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            // 设置显示图片为不可见
                            pwd_visible.setImageResource(R.drawable.pwd_unvisible);
                        }
                        isHidden = !isHidden;
                        et_pwd.postInvalidate();
                        // 切换后，密码输入框的光标切换到末尾
                        CharSequence charSequence = et_pwd.getText();
                        if(charSequence instanceof Spannable){
                            Spannable spanText = (Spannable) charSequence;
                            Selection.setSelection(spanText,charSequence.length());
                        }
                        break;
                        // 单击注册按钮，跳转到注册界面
                    case R.id.register:
                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                        break;
                        // 单击忘记密码，跳转到找回密码界面
                    case R.id.pwd_forget:
                        startActivity(new Intent(LoginActivity.this,ForgetPassWordActivity.class));
                        break;
                }

            }
        };
        verifyCode_login.setOnClickListener(listener); // 短信验证码监听器
        pwd_visible.setOnClickListener(listener);   // 控制密码可见或不可见
        register.setOnClickListener(listener); // 注册按钮监听器
        pwd_forget.setOnClickListener(listener); //忘记密码监听器
    }

    private void initView() {
        verifyCode_login = findViewById(R.id.verifyCode_login); // 短信验证码按钮
        et_pwd = findViewById(R.id.et_pwd);  // 密码输入框
        pwd_visible = findViewById(R.id.pwd_visible); // 控制密码可见或不可见
        register = findViewById(R.id.register); // 注册按钮
        pwd_forget = findViewById(R.id.pwd_forget); // 忘记密码按钮
    }
}
