package com.example.dakaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakaapp.dao.DakaDao;
import com.example.dakaapp.entity.DakaInfo;
import com.example.dakaapp.utils.DataTimeDialogUtil;
import com.example.dakaapp.utils.ToastUtil;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_time;
    private EditText et_key;
    private EditText et_content;
    private TextView tv_jianchi;
    private TextView tv_lianxu;
    private DakaDao dakaDao;
    List<DakaInfo> list;
    private int jianshi = 0;
    private int max = 0;
    private EditText et_tixing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dakaDao = new DakaDao();
        et_time = findViewById(R.id.et_time);
        et_key = findViewById(R.id.et_key);
        et_content = findViewById(R.id.et_content);
        tv_jianchi = findViewById(R.id.tv_jianchi);
        tv_lianxu = findViewById(R.id.tv_lianxu);
        et_tixing = findViewById(R.id.et_tixing);
        getListInfo();
        findViewById(R.id.btn_daka).setOnClickListener(this);
        findViewById(R.id.btn_flse).setOnClickListener(this);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_tixing).setOnClickListener(this);
        findViewById(R.id.btn_data).setOnClickListener(this);
        findViewById(R.id.btn_chakan).setOnClickListener(this);

    }



    private void getListInfo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                list = dakaDao.getAllDakaInfo();
                countMax();
            }
        }).start();
    }

    private void countMax() {
        int max = 0;
        int last = 0;
        int cnt = 1;
        for (int i = 0; i < list.size(); i ++){
            if (list.get(i).shijian == cnt ++){
                last ++;
            }else{
                max = Math.max(last, max);
                last = 1;
                cnt = list.get(i).shijian + 1;
            }
        }
        max = Math.max(last, max);
        tv_jianchi.setText("坚持天数:" + last);
        tv_lianxu.setText("最长连续天数:" + max);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_daka:
                addInfo();
                break;
            case R.id.btn_flse:
                getListInfo();
                break;
            case R.id.btn_tixing:
                setTixing();
                break;
            case R.id.btn_data:
                DataTimeDialogUtil.setData(this, et_time);
                break;
            case R.id.btn_chakan:
                Intent intent = new Intent(this, JiLuActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void setTixing() {
        DataTimeDialogUtil.Alert(this, et_tixing.getText().toString());
    }

    private void addInfo() {
        DakaInfo dakaInfo = new DakaInfo();
        dakaInfo.setKeyword(et_key.getText().toString());
        dakaInfo.setContent(et_content.getText().toString());
        String[] strings = et_time.getText().toString().split("\\.");

        dakaInfo.setShijian(Integer.parseInt(  strings[1] ));
        new Thread(new Runnable() {
            @Override
            public void run() {
                dakaDao.add(dakaInfo);
            }
        }).start();
        ToastUtil.show(this, "打卡成功!");
    }
}