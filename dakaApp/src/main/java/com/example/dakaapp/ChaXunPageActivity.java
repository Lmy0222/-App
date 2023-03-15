package com.example.dakaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.dakaapp.adapter.DakaBaseAdapter;
import com.example.dakaapp.entity.DakaInfo;

import java.util.List;

public class ChaXunPageActivity extends AppCompatActivity implements View.OnClickListener {

    private List<DakaInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_xun_page);
        ListView lv_item = findViewById(R.id.lv_item);
        list = (List<DakaInfo>) getIntent().getSerializableExtra("list");
        DakaBaseAdapter baseAdapter = new DakaBaseAdapter(this, list);
        lv_item.setAdapter(baseAdapter);

        findViewById(R.id.iv_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}