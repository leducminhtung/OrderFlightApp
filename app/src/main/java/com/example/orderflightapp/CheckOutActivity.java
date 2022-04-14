package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import InterfaceReponsitory.Methods;
import Model.CangModel;
import Model.ChuyenBayModel;
import Model.PhieuMuaVeInsertModel;
import Model.TaiKhoanModel;
import Model.VeInsertModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckOutActivity extends AppCompatActivity {

    int sl_hk = 0;
    int nhapPhieuMuaVe = 0;
    ChuyenBayModel.Items chuyenbaydachon;
    List<CangModel.Items> cangBayAdapter = new ArrayList<>();
    ArrayList<VeInsertModel> dsVe = new ArrayList<>();
    ArrayList<PhieuMuaVeInsertModel> dsPhieu = new ArrayList<>();

    TextView txtMaybay, txtNoidi, txtNoiden, txtGioidi, txtCC, txtHoten, txtSDT, txtEmail, txtSL_HK, txtPrice, txtTotal;
    LinearLayout lnrCheck_HK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        chuyenbaydachon = (ChuyenBayModel.Items) getIntent().getSerializableExtra("ChuyenBayDaChon");
        GetIdView();
        SetData();
    }

    public void GetIdView(){
        txtMaybay =findViewById(R.id.txtCheck_TenMayBay);
        txtNoidi = findViewById(R.id.txtCheck_MaCangDi);
        txtNoiden = findViewById(R.id.txtCheck_MaCangDen);
        txtGioidi = findViewById(R.id.txtCheck_NgayGioDi);
        txtCC = findViewById(R.id.txtCheck_CC);
        txtHoten = findViewById(R.id.txtCheck_hoten);
        txtSDT = findViewById(R.id.txtCheck_sdt);
        txtEmail = findViewById(R.id.txtCheck_Email);
        txtSL_HK = findViewById(R.id.txtCheck_SL);
        txtPrice = findViewById(R.id.txtCheck_Gia);
        txtTotal = findViewById(R.id.txtCheck_Sum);
        lnrCheck_HK = findViewById(R.id.lnrCheck_HK);
    }

    public void SetData(){
        Intent mIntent = getIntent();
        sl_hk = mIntent.getIntExtra("SL_HanhKhach", 0);
        txtMaybay.setText(chuyenbaydachon.getMacangdi());
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
                        txtNoidi.setText(cangBayAdapter.get(i).getTinh());
                    }else if(cangden.equals(cangBayAdapter.get(i).getMacang())){
                        txtNoiden.setText(cangBayAdapter.get(i).getTinh());
                    }
                }
            }
            @Override
            public void onFailure(Call<CangModel> call, Throwable t) {
            }
        });
        txtGioidi.setText(chuyenbaydachon.getGiobay() +" "+chuyenbaydachon.getNgaybay());
        txtCC.setText(LoginActivity.TaiKhoan.getCancuoc());
        txtHoten.setText(LoginActivity.TaiKhoan.getTenkh());
        txtSDT.setText(LoginActivity.TaiKhoan.getSdt());
        txtEmail.setText(LoginActivity.TaiKhoan.getEmail());
        txtSL_HK.setText(String.valueOf(sl_hk));
        txtPrice.setText(chuyenbaydachon.getGv());
        double GiaHK = Double.parseDouble(txtPrice.getText().toString());

        double tong = GiaHK * sl_hk;

        txtTotal.setText(Double.toString(tong).replace(".0","")+"đ");


    }

    public void Back(View view) {finish();
    }

    public void ThanhToan(View view) {
    }

}
