package com.example.dakaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dakaapp.dao.DakaDao;
import com.example.dakaapp.entity.DakaInfo;

import java.io.Serializable;
import java.util.List;

public class JiaoshiActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_guanjianzi;
    private EditText et_neirong;
    private TextView tv_xianshi;
    DakaDao dakaDao;
    List<DakaInfo> list;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 0){
                tv_xianshi.setText((String)msg.obj);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiaoshi);
        et_guanjianzi = findViewById(R.id.et_guanjianzi);
        et_neirong = findViewById(R.id.et_neirong);
        tv_xianshi = findViewById(R.id.tv_xianshi);
        findViewById(R.id.btn_xianshi).setOnClickListener(this);
        findViewById(R.id.btn_guanjianxianshi).setOnClickListener(this);
        findViewById(R.id.btn_zongjiexianshi).setOnClickListener(this);
        findViewById(R.id.iv_back).setOnClickListener(this);
        dakaDao = new DakaDao();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            default:
                Intent intent = new Intent(this, ChaXunPageActivity.class);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        switch (view.getId()){
                            case R.id.btn_xianshi:
                                list = dakaDao.selAll();
                                break;
                            case R.id.btn_guanjianxianshi:
                                list = dakaDao.selByKey(et_guanjianzi.getText().toString());
                                break;
                            case R.id.btn_zongjiexianshi:
                                list = dakaDao.selByContent(et_neirong.getText().toString());
                                break;
                        }

                        intent.putExtra("list", (Serializable) list);
                        startActivity(intent);
                        String text = "";
//                        for (DakaInfo dakaInfo : list) {
//                            text += dakaInfo.toString() + "/n";
//                        }
                        Message msg = Message.obtain();
                        msg.what = 0;
                        msg.obj = text;
                        handler.sendMessage(msg);
                    }
                }).start();
                break;
        }




    }
}