package com.example.dakaapp.utils;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.AlarmClock;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class DataTimeDialogUtil {
    private static TimePickerDialog timePickerDialog;
    private static Calendar calendar;
    private static DatePickerDialog datePickerDialog;

    public static void setData(Context _this, EditText editText){
        calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(_this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                editText.setText((i1 + 1) + "." + i2 );
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) );
        datePickerDialog.show();
    }

    public static void Alert(Context _this, String content){
        calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(_this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                Log.e(TAG, "onTimeSet hourOfDay: " + hourOfDay + ", minute: " + minute);
                setAlarm(hourOfDay, minute, content, _this);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }
    private static void setAlarm(int hour, int minute, String content, Context _this) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, content);
        intent.putExtra(AlarmClock.EXTRA_VIBRATE, true);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
//        ArrayList<Integer> days = new ArrayList<>();
//        days.add(Calendar.SUNDAY);
//        days.add(Calendar.MONDAY);
//        days.add(Calendar.TUESDAY);
//        days.add(Calendar.WEDNESDAY);
//        days.add(Calendar.THURSDAY);
//        days.add(Calendar.FRIDAY);
//        days.add(Calendar.SATURDAY);
//        intent.putExtra(AlarmClock.EXTRA_DAYS, days);
        boolean resolvedActivity = intent.resolveActivity(_this.getPackageManager()) != null;
//        Log.v(TAG, "resolvedActivity = " + resolvedActivity);
        try {
            _this.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
