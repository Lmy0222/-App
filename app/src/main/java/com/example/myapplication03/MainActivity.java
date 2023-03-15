package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication03.database.UserDBHelper;
import com.example.myapplication03.entity.User;
import com.example.myapplication03.utils.ToastUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_id;
    private EditText et_pwd;
    private UserDBHelper mHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_zhuce).setOnClickListener(this);
        et_id = findViewById(R.id.et_id);
        et_pwd = findViewById(R.id.et_pwd);



        reloade();
    }

    private void reloade() {
        List<User> users = mHelper.queryAll();
//        if (users)

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login:
                User user = mHelper.queryById(et_id.getText().toString());
                if (user != null && user.password.equals(et_pwd.getText().toString())){
                    // 登录成功
                    ToastUtil.show(this, "登录成功");
                }else{
                    // 登录失败
                    ToastUtil.show(this, "登录失败");

                }
                break;
            case R.id.btn_zhuce:
                Intent intent = new Intent(this, ZhuceActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHelper = UserDBHelper.getInstance(this);
        mHelper.openReadLink();
        mHelper.openWriteLink();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mHelper.closeLink();
    }
}