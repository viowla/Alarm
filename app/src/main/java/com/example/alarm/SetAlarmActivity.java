package com.example.alarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class SetAlarmActivity extends AppCompatActivity {

    Button setAlarm;
    EditText alarmTitle;
    TimePicker timePicker;
    int hour, minute;
    String time;
    Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        setAlarm = findViewById(R.id.button2);
        alarmTitle = findViewById(R.id.editText);
        timePicker = findViewById(R.id.timePicker);

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                hour = timePicker.getHour();
                minute = timePicker.getMinute();
                time.equals(alarmTitle.getText());
                Intent intent = new Intent(SetAlarmActivity.this, MainActivity.class);
                String[] s = new String[]{time};
                intent.putExtra("string",s);
                startActivity(intent);
            }
        });
    }
}