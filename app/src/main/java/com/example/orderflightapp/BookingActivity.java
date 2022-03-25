package com.example.orderflightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Toast;
import androidx.annotation.Nullable;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    NumberPicker hanhkhach;

    final Calendar ngaydiCalendar= Calendar.getInstance();
    final Calendar ngaydenCalendar= Calendar.getInstance();
    CheckBox checkBox;

    AutoCompleteTextView NoiDen,NoiDi,NgayVe,NgayDi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //numberpicker
        hanhkhach = findViewById(R.id.numpickAdult);
        hanhkhach.setMinValue(0);
        hanhkhach.setMaxValue(5);

        hanhkhach.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%d", value);
            }
        });
        hanhkhach.setOnValueChangedListener(this);


        NgayDi=(AutoCompleteTextView) findViewById(R.id.txtNgayDi);
        DatePickerDialog.OnDateSetListener datelichdi =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                ngaydiCalendar.set(Calendar.YEAR, year);
                ngaydiCalendar.set(Calendar.MONTH,month);
                ngaydiCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        NgayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(BookingActivity.this,datelichdi,ngaydiCalendar.get(Calendar.YEAR),ngaydiCalendar.get(Calendar.MONTH),ngaydiCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        NgayVe=(AutoCompleteTextView) findViewById(R.id.txtNgayVe);
        DatePickerDialog.OnDateSetListener datelichve =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                ngaydenCalendar.set(Calendar.YEAR, year);
                ngaydenCalendar.set(Calendar.MONTH,month);
                ngaydenCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        NgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(BookingActivity.this,datelichve,ngaydenCalendar.get(Calendar.YEAR),ngaydenCalendar.get(Calendar.MONTH),ngaydenCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void updateLabel(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.SIMPLIFIED_CHINESE);
        NgayDi.setText(dateFormat.format(ngaydiCalendar.getTime()));
        NgayVe.setText(dateFormat.format(ngaydenCalendar.getTime()));
    }

    public void UpValueAdult(View view) {
    }

    public void DownValueAdult(View view) {
    }

    public void GoToHome2(View view) {
        Intent intent = new Intent(BookingActivity.this, Index.class);
        startActivity(intent);
    }

    public void GoToListFlights(View view) {
    }


    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
        Log.i("Values is" ," " + newVal);

    }


}
