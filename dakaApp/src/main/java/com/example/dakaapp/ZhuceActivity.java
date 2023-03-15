package com.example.dakaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dakaapp.database.UserDBHelper;
import com.example.dakaapp.entity.User;
import com.example.dakaapp.utils.ToastUtil;


public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private EditText et_id;
    private EditText et_name;
    private EditText et_phone;
    private EditText et_banji;
    private EditText et_pwd;
    private UserDBHelper mHelper;
    private EditText et_pwd2;
    private TextView tv_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);


        findViewById(R.id.btn_zhuce).setOnClickListener(this);
        et_id = findViewById(R.id.et_id);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_banji = findViewById(R.id.et_banji);
        et_pwd = findViewById(R.id.et_pwd);
        et_pwd2 = findViewById(R.id.et_pwd2);
        et_pwd2.setOnFocusChangeListener(this);
        tv_error = findViewById(R.id.tv_error);
        findViewById(R.id.iv_back).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mHelper = UserDBHelper.getInstance(this);
        mHelper.openReadLink();
        mHelper.openWriteLink();

    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        mHelper.closeLink();
//    }
//public String name;
//    public String phone;
//    public String banji;1
//    public String password;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
//                finish();
                finish();
                break;
            case R.id.btn_zhuce:
                User user = new User();
                user.id = et_id.getText().toString();
                user.name = et_name.getText().toString();
                user.phone = et_phone.getText().toString();
                user.banji = et_banji.getText().toString();
                user.password = et_pwd.getText().toString();
                mHelper.insert(user);
                ToastUtil.show(this, "注册成功，请登录!");
                finish();
                break;
        }


    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b == false && !et_pwd.getText().toString().equals(et_pwd2.getText().toString())){
               tv_error.setVisibility(View.VISIBLE);
        }else if((b == false && et_pwd.getText().toString().equals(et_pwd2.getText().toString()))){
            tv_error.setVisibility(View.INVISIBLE);
        }
    }
}