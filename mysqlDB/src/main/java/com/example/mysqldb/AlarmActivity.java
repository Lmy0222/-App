package com.example.mysqldb;

import android.Manifest;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by tzbc
 */
public class AlarmActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AlarmActivity";

    private Button btAlarm;
    private TimePickerDialog timePickerDialog;
    private Calendar calendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nao_zhong);

        calendar = Calendar.getInstance();

        btAlarm = findViewById(R.id.btAlarm);
        btAlarm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        if (v.getId() == R.id.btAlarm) {
            Log.v(TAG, "click btAlarm");
//            boolean hasAlarmPermission = PermissionUtil.judgeHasPermissions(this, Manifest.permission.SET_ALARM);
//            Log.v(TAG, "hasAlarmPermission = " + hasAlarmPermission);
//            if (!hasAlarmPermission) {
//                Log.e(TAG, "alarm permission not granted");
//                return;
//            }
            showTimeDialog();
        }
    }

    private void showTimeDialog() {
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.e(TAG, "onTimeSet hourOfDay: " + hourOfDay + ", minute: " + minute);
                setAlarm(hourOfDay, minute);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private void setAlarm(int hour, int minute) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "tzbc");
        intent.putExtra(AlarmClock.EXTRA_VIBRATE, true);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        ArrayList<Integer> days = new ArrayList<>();
        days.add(Calendar.SUNDAY);
        days.add(Calendar.MONDAY);
        days.add(Calendar.TUESDAY);
        days.add(Calendar.WEDNESDAY);
        days.add(Calendar.THURSDAY);
        days.add(Calendar.FRIDAY);
        days.add(Calendar.SATURDAY);
        intent.putExtra(AlarmClock.EXTRA_DAYS, days);
        boolean resolvedActivity = intent.resolveActivity(getPackageManager()) != null;
        Log.v(TAG, "resolvedActivity = " + resolvedActivity);
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}