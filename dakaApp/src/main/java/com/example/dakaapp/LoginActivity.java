package com.example.dakaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dakaapp.database.UserDBHelper;
import com.example.dakaapp.entity.User;
import com.example.dakaapp.utils.ToastUtil;


import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_id;
    private EditText et_pwd;
    private UserDBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_zhuce).setOnClickListener(this);
        findViewById(R.id.btn_jiaoshilogin).setOnClickListener(this);
        et_id = findViewById(R.id.et_id);
        et_pwd = findViewById(R.id.et_pwd);
        findViewById(R.id.iv_back).setOnClickListener(this);
//
//
//

    }
//
    private void reloade() {
        List<User> users = mHelper.queryAll();
        if (users.size() != 0){
            et_id.setText(users.get(0).id);
            et_pwd.setText(users.get(0).password);
        }
    }
//
//    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_login:
                System.out.println("正在登陆");
                User user = mHelper.queryById(et_id.getText().toString());
                if (user != null && user.password.equals(et_pwd.getText().toString())){
                    // 登录成功
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    ToastUtil.show(this, "登录成功");
                    System.out.println("登陆成功");
                }else{
                    // 登录失败
                    ToastUtil.show(this, "登录失败");
                    System.out.println("登录失败");

                }
                break;
            case R.id.btn_jiaoshilogin:
                System.out.println("正在登陆");
                User user1 = mHelper.queryById(et_id.getText().toString());
                if (user1 != null && user1.password.equals(et_pwd.getText().toString())){
                    // 登录成功
                    Intent intent = new Intent(this, JiaoshiActivity.class);
                    startActivity(intent);
                    ToastUtil.show(this, "登录成功");
                    System.out.println("登陆成功");
                }else{
                    // 登录失败
                    ToastUtil.show(this, "登录失败");
                    System.out.println("登录失败");

                }
                break;
            case R.id.btn_zhuce:
                Intent intent = new Intent(this, ZhuceActivity.class);
                startActivity(intent);
                break;
        }
    }
//
    @Override
    protected void onStart() {
        super.onStart();
        mHelper = UserDBHelper.getInstance(this);
        mHelper.openReadLink();
        mHelper.openWriteLink();
        reloade();

    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        mHelper.closeLink();
//    }
}