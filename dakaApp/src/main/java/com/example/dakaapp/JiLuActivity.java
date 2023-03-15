package com.example.dakaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.dakaapp.dao.DakaDao;
import com.example.dakaapp.entity.DakaInfo;
import com.example.dakaapp.utils.DataTimeDialogUtil;

import java.util.ArrayList;
import java.util.List;

public class JiLuActivity extends AppCompatActivity implements View.OnClickListener {

    List<DakaInfo> list;
    List<TextView> textViews;
    DakaDao dakaDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_lu);
        dakaDao = new DakaDao();
        textViews = new ArrayList<>();
        findViewById(R.id.iv_back).setOnClickListener(this);
        textViews.add(null);
        textViews.add(findViewById(R.id.tv_1));
        textViews.add(findViewById(R.id.tv_2));
        textViews.add(findViewById(R.id.tv_3));
        textViews.add(findViewById(R.id.tv_4));
        textViews.add(findViewById(R.id.tv_5));
        textViews.add(findViewById(R.id.tv_6));
        textViews.add(findViewById(R.id.tv_7));
        textViews.add(findViewById(R.id.tv_8));
        textViews.add(findViewById(R.id.tv_9));
        textViews.add( findViewById(R.id.tv_10));
        textViews.add( findViewById(R.id.tv_11));
        textViews.add( findViewById(R.id.tv_12));
        textViews.add( findViewById(R.id.tv_13));
        textViews.add( findViewById(R.id.tv_14));
        textViews.add( findViewById(R.id.tv_15));
        textViews.add( findViewById(R.id.tv_16));
        textViews.add( findViewById(R.id.tv_17));
        textViews.add( findViewById(R.id.tv_18));
        textViews.add( findViewById(R.id.tv_19));
        textViews.add( findViewById(R.id.tv_20));
        textViews.add( findViewById(R.id.tv_21));
        textViews.add( findViewById(R.id.tv_22));
        textViews.add( findViewById(R.id.tv_23));
        textViews.add( findViewById(R.id.tv_24));
        textViews.add( findViewById(R.id.tv_25));
        textViews.add( findViewById(R.id.tv_26));
        textViews.add( findViewById(R.id.tv_27));
        textViews.add( findViewById(R.id.tv_28));
        textViews.add( findViewById(R.id.tv_29));
        textViews.add( findViewById(R.id.tv_30));
        textViews.add( findViewById(R.id.tv_31));



        new Thread(new Runnable() {
            @Override
            public void run() {
                list = dakaDao.selAll();
                for (DakaInfo dakaInfo : list) {
                    textViews.get(dakaInfo.getShijian()).setTextColor(Color.GREEN);
                }
            }
        }).start();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}