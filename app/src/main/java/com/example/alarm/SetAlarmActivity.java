package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class SetAlarmActivity extends AppCompatActivity {

    Button setAlarm;
    EditText alarmTitle;
    TimePicker timePicker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        setAlarm = findViewById(R.id.button2);
        alarmTitle = findViewById(R.id.editText);
        timePicker = findViewById(R.id.timePicker);
    }
}