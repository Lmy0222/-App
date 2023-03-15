package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication03.database.UserDBHelper;
import com.example.myapplication03.entity.User;

public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_id;
    private EditText et_name;
    private EditText et_phone;
    private EditText et_banji;
    private EditText et_pwd;
    private UserDBHelper mHelper;

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
//public String name;
//    public String phone;
//    public String banji;
//    public String password;
    @Override
    public void onClick(View view) {
        User user = new User();
        user.id = et_id.getText().toString();
        user.name = et_name.getText().toString();
        user.phone = et_phone.getText().toString();
        user.banji = et_banji.getText().toString();
        user.password = et_pwd.getText().toString();
        mHelper.insert(user);
    }
}