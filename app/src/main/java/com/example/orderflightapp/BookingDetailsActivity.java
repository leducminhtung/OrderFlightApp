package com.example.orderflightapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import Model.ChuyenBayModel;

public class BookingDetailsActivity extends AppCompatActivity {

    ChuyenBayModel.Items chuyenbaydachon;
    TextView txtTenCangDi,txtTenCangDen,txtNgayGioDi, txtThoiLuongBay, txtSLHK, txtGiaTienHK, txtTongTien;
    LinearLayout lnr_details_hk;
    int slHK = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_booking);
        chuyenbaydachon = (ChuyenBayModel.Items) getIntent().getSerializableExtra("ChuyenBayDaChon");

        GetIdView();
        GetDataItem();

    }
    public void GetIdView(){

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



        txtTenCangDi.setText(chuyenbaydachon.getTencangdi());
        txtTenCangDen.setText(chuyenbaydachon.getTencangden());
        txtNgayGioDi.setText(chuyenbaydachon.getGiobay() +" "+chuyenbaydachon.getNgaybay());
        txtThoiLuongBay.setText(chuyenbaydachon.getThoiluongcb() + "phút");
        txtSLHK.setText(String.valueOf(slHK));
        txtGiaTienHK.setText(chuyenbaydachon.getGvht());

        double GiaHK = Double.parseDouble(txtGiaTienHK.getText().toString());

        double tong = GiaHK * slHK;

        txtTongTien.setText(Double.toString(tong).replace(".0","") + "đ");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void GoToInfoCustomer(View view) {

    }

    public void BackToList(View view) {
    }
}
