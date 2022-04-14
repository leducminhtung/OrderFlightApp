package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import InterfaceReponsitory.Methods;
import Model.CangModel;
import Model.ChuyenBayModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingDetailsActivity extends AppCompatActivity {

    ChuyenBayModel.Items chuyenbaydachon;
    TextView txtTenCangDi,txtTenCangDen,txtNgayGioDi, txtThoiLuongBay, txtSLHK, txtGiaTienHK, txtTongTien, txtTrungChuyen, txtTGDung;
    LinearLayout lnr_details_hk;
    int slHK = 0;
    List<CangModel.Items> cangBayAdapter = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_booking);
        chuyenbaydachon = (ChuyenBayModel.Items) getIntent().getSerializableExtra("ChuyenBayDaChon");

        GetIdView();
        GetDataItem();

    }
    public void GetIdView(){

        txtTrungChuyen = findViewById(R.id.txtTrungChuyen);
        txtTGDung = findViewById(R.id.txtTGdung);
        txtTenCangDi =findViewById(R.id.txtTenCangDi);
        txtTenCangDen = findViewById(R.id.txtTenCangDen);
        txtNgayGioDi = findViewById(R.id.txtNgayGioDi);
        txtSLHK = findViewById(R.id.txtSL_HK);
        txtGiaTienHK = findViewById(R.id.txtPriceHK);
        txtThoiLuongBay = findViewById(R.id.txtThoiLuongBay);
        txtTongTien = findViewById(R.id.txtCheck_SumPrice);
        lnr_details_hk = findViewById(R.id.lnr_detais_hk);


    }


    public void GetDataItem(){
        Intent intent = getIntent();
        slHK = intent.getIntExtra("SL_HanhKhach", 0);
        String cangdi = chuyenbaydachon.getMacangdi();
        String cangden = chuyenbaydachon.getMacangden();
        Methods methods = getRetrofit().create(Methods.class);
        Call<CangModel> call = methods.GetCangs();
        call.enqueue(new Callback<CangModel>() {
            @Override
            public void onResponse(Call<CangModel> call, Response<CangModel> response) {
                List<CangModel.Items> data = response.body().getItems();
                cangBayAdapter= data;
                for(int i = 0; i<cangBayAdapter.size();i++){
                    if(cangdi.equals(cangBayAdapter.get(i).getMacang())){
                        txtTenCangDi.setText(cangBayAdapter.get(i).getTencang());
                    }else if(cangden.equals(cangBayAdapter.get(i).getMacang())){
                        txtTenCangDen.setText(cangBayAdapter.get(i).getTencang());
                    }
                }
            }

            @Override
            public void onFailure(Call<CangModel> call, Throwable t) {

            }
        });

        txtNgayGioDi.setText(chuyenbaydachon.getGiobay() +" "+chuyenbaydachon.getNgaybay());
        txtThoiLuongBay.setText(chuyenbaydachon.getThoiluongcb() + "phút");
        txtSLHK.setText(String.valueOf(slHK));
        txtGiaTienHK.setText(chuyenbaydachon.getGv());
        if(chuyenbaydachon.getThoigiandung() == null){
            txtTGDung.setEnabled(false);
        }else{
            txtTGDung.setText(chuyenbaydachon.getThoigiandung() + "phút");
        }
        if(chuyenbaydachon.getGhichu() == null){
            txtTrungChuyen.setEnabled(false);
        }else {
            txtTrungChuyen.setText(chuyenbaydachon.getGhichu());
        }


        double GiaHK = Double.parseDouble(txtGiaTienHK.getText().toString());

        double tong = GiaHK * slHK;

        txtTongTien.setText(Double.toString(tong).replace(".0","") + "đ");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void GoToInfoCustomer(View view) {
        Intent i = new Intent(BookingDetailsActivity.this, CheckOutActivity.class);
        startActivity(i);

    }

    public void BackToList(View view) {
        Intent i = new Intent(BookingDetailsActivity.this, BookingActivity.class);
        startActivity(i);
    }
}
