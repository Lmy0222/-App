package com.example.mysqldb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_hello;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 0){
                int count = (int) msg.obj;
                tv_hello.setText("数据库中用数量为"  + count);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_sel).setOnClickListener(this);
        tv_hello = findViewById(R.id.tv_hello);
    }

    @Override
    public void onClick(View view) {
        doQuryCount();
    }

    private void doQuryCount() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = MySqlHelp.getUserSize();
                Message msg = Message.obtain();
                msg.what = 0;
                msg.obj = count;
                handler.sendMessage(msg);
            }
        }).start();

    }
}