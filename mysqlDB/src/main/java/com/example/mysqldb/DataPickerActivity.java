package com.example.mysqldb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.android.material.datepicker.MaterialDatePicker;

public class DataPickerActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_picker);

        MaterialDatePicker<Pair<Long, Long>> dateRangePicker = MaterialDatePicker.Builder
                .dateRangePicker()
//                .setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar)
                .setTitleText("Title")
                .setSelection(
                        new Pair<>(
                                MaterialDatePicker.thisMonthInUtcMilliseconds(),
                                MaterialDatePicker.todayInUtcMilliseconds()
                        )
                )
                .build();
//        dateRangePicker.show();
        FragmentManager childFragmentManager = new FragmentManager() {
        };
//        dateRangePicker.show(childFragmentManager, "tag");
//        dateRangePicker.addOnPositiveButtonClickListener {
//            println(it.first)
//            println(it.second)
//
//        }
    }
}