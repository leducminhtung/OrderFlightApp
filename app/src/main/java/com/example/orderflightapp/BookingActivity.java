package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

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
import androidx.work.Data;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


import InterfaceReponsitory.Methods;
import Model.CangModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {

    NumberPicker hanhkhach;

    final Calendar ngaydiCalendar= Calendar.getInstance();
    final Calendar ngayveCalendar= Calendar.getInstance();
    CheckBox checkBox, ckbvethuong, ckbveTG;
    List<CangModel.Items> cangBayAdapter = new ArrayList<>();

    AutoCompleteTextView NoiDen,NoiDi,NgayVe,NgayDi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        cangBayAdapter = new ArrayList<>();

        init();
        //numberpicker
        hanhkhach = findViewById(R.id.numpickAdult);
        hanhkhach.setMinValue(0);
        hanhkhach.setMaxValue(4);

        hanhkhach.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return String.format("%d", value);
            }
        });
        hanhkhach.setOnValueChangedListener(this);


        NgayDi=(AutoCompleteTextView) findViewById(R.id.txtNgayDi);
        DatePickerDialog.OnDateSetListener datelichdi = new DatePickerDialog.OnDateSetListener() {
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
                ngayveCalendar.set(Calendar.YEAR, year);
                ngayveCalendar.set(Calendar.MONTH,month);
                ngayveCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        NgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(BookingActivity.this,datelichve,ngayveCalendar.get(Calendar.YEAR),ngayveCalendar.get(Calendar.MONTH),ngayveCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void GetCangBay(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<CangModel> call = methods.GetCangs();
        call.enqueue(new Callback<CangModel>() {
            @Override
            public void onResponse(Call<CangModel> call, Response<CangModel> response) {
                List<CangModel.Items> data = response.body().getItems();
                cangBayAdapter= data;
                LayCangBay();
                NoiDen.getText();
            }

            @Override
            public void onFailure(Call<CangModel> call, Throwable t) {
                Log.v("Thất bại rồi !","Thất bại rồi !" + "\n");
            }
        });
    }

    public void LayCangBay(){
        List<String> dsTenCang = new ArrayList<>();

        for(int i=0;i<cangBayAdapter.size();i++){
            dsTenCang.add(cangBayAdapter.get(i).getTencang());
        }

        String[] items = {"SGN", "HAN", "DAD", "ASH"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.dropdown_items, dsTenCang);


        NoiDi.setAdapter(adapter);

        NoiDen.setAdapter(adapter);

        NoiDi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });

        NoiDen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updateLabel(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.SIMPLIFIED_CHINESE);
        NgayDi.setText(dateFormat.format(ngaydiCalendar.getTime()));
        NgayVe.setText(dateFormat.format(ngayveCalendar.getTime()));
    }

    public void UpValue(View view) {
        int sohientai = hanhkhach.getValue();
        hanhkhach.setValue(sohientai+1);
    }

    public void DownValue(View view) {
        int sohientai = hanhkhach.getValue();
        hanhkhach.setValue(sohientai-1);
    }

    public void GoToHome2(View view) {
        Intent intent = new Intent(BookingActivity.this, Index.class);
        startActivity(intent);
    }

    public void GoToListFlights(View view) {
    }
    public void init(){
        checkBox = findViewById(R.id.pa);
        checkBox.setOnCheckedChangeListener(mLinear);
        ckbvethuong = findViewById(R.id.vethuong);
        ckbvethuong.setOnCheckedChangeListener(mLinear1);
        ckbveTG = findViewById(R.id.vethuonggia);
        ckbveTG.setOnCheckedChangeListener(mLinear2);
        NgayVe = findViewById(R.id.txtNgayVe);
        NgayDi = findViewById(R.id.txtNgayDi);
        NoiDen = findViewById(R.id.txtNoiDen);
        NoiDi =  findViewById(R.id.txtNoiDi);
        GetCangBay();
    }
    CompoundButton.OnCheckedChangeListener mLinear = new CompoundButton.OnCheckedChangeListener() {
        @SuppressLint("WrongConstant")
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Toast.makeText(BookingActivity.this,
                        "Bạn đã chọn : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                NgayVe.setEnabled(true);
            }
            else
            {
                Toast.makeText(BookingActivity.this,
                        "Bạn hủy chọn : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                NgayVe.setEnabled(false);
            }
        }
    };
    CompoundButton.OnCheckedChangeListener mLinear1 = new CompoundButton.OnCheckedChangeListener() {
        @SuppressLint("WrongConstant")
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Toast.makeText(BookingActivity.this,
                        "Bạn đã chọn : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                ckbveTG.setEnabled(false);
            }
            else
            {
                Toast.makeText(BookingActivity.this,
                        "Bạn hủy chọn : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                ckbveTG.setEnabled(true);
            }
        }
    };
    CompoundButton.OnCheckedChangeListener mLinear2 = new CompoundButton.OnCheckedChangeListener() {
        @SuppressLint("WrongConstant")
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                Toast.makeText(BookingActivity.this,
                        "Bạn đã chọn : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                ckbvethuong.setEnabled(false);
            }
            else
            {
                Toast.makeText(BookingActivity.this,
                        "Bạn hủy chọn : " + buttonView.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                ckbvethuong.setEnabled(true);
            }
        }
    };


    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
        Log.i("Values is" ," " + newVal);

    }


}
