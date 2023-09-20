package com.example.dialogwindows;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;
    ImageButton dateBtn, timeBtn;
    Button applyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBtn = findViewById(R.id.date_btn);
        timeBtn = findViewById(R.id.time_btn);
        applyBtn = findViewById(R.id.apply_btn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int year = 2021;
                int month = 11;
                int date = 14;
                DatePickerDialog.OnDateSetListener datePick = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateTxt.setText(i2+"-"+(i1+1)+"-"+i);

                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,datePick, year,month,date);
                datePickerDialog.show();
            }
        });
    timeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int hour = 1;
            int minute = 24;
            boolean is24Hours = true;

            TimePickerDialog.OnTimeSetListener timePick = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                    timeTxt.setText(i+":"+i1);

                }
            };
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,timePick, hour,minute,is24Hours);
        timePickerDialog.show();
        }
    });

    applyBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Подтверждение записи")
                    .setIcon(R.drawable.ic_date)
                    .setMessage("Вы подтверждаете запись?")
                    .setPositiveButton("Da", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.cancel();
                            Toast.makeText(MainActivity.this, "asdasdasd", Toast.LENGTH_SHORT).show();
                        }
                    })

                    .setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    })
                    .create();
            builder.show();
        }
    });

    }
}