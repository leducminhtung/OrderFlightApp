package com.example.orderflightapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class FragmentAccount extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;

    TextView txtCustomerName, txtHangTV;
    TextInputEditText txtname, txtEmail, txtSDT, txtBD, txtGioiTinh, txtmk;
    AutoCompleteTextView txtGT;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.activity_account, container, false);
        getViewId(inf);
//        if(LoginActivity.TaiKhoan.getCancuoc() != null){
//            LoginActivity.TaiKhoan.setCancuoc("");
//        }
        setData();


        return inf;
    }
    public void refresh(int m){
        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                setData();
            }
        };
        handler.postDelayed(runnable, m);
    }
    public void setData(){

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>();
//        txtGT.setAdapter(arrayAdapter);

        txtCustomerName.setText(LoginActivity.TaiKhoan.getTenkh());
        txtEmail.setText(LoginActivity.TaiKhoan.getEmail());
        txtSDT.setText(LoginActivity.TaiKhoan.getSdt());
        txtBD.setText(LoginActivity.TaiKhoan.getNgaysinh().replace("T17:00:00Z", ""));
        String gt = LoginActivity.TaiKhoan.getGioitinh();
        if(gt.equals("0")){
            txtGioiTinh.setText("Nam");
        }else{
            txtGioiTinh.setText("Nữ");
        }
//        txtGT.setAdapter(LoginActivity.TaiKhoan.getGioitinh(a));
        txtname.setText(LoginActivity.TaiKhoan.getTenkh());
        txtmk.setText(LoginActivity.TaiKhoan.getMatkhau());
        String tv = LoginActivity.TaiKhoan.getHangtv();
        if(tv.equals("0")){
            txtHangTV.setText("Hạng Đồng");
        }else if(tv.equals("1")){
            txtHangTV.setText("Hạng Bạc");
        }else {
            txtHangTV.setText("Hạng vàng");
        }
        refresh(15000);
    }
    public void getViewId(View inf){



        txtname = (TextInputEditText)inf.findViewById(R.id.txtCustomerName);
        txtCustomerName =(TextView)inf.findViewById(R.id.txtCustomUserName);
        txtHangTV = (TextView) inf.findViewById(R.id.txtHangTV);
        txtEmail = (TextInputEditText) inf.findViewById(R.id.txtCustomerEmail);
//        txtCC = (TextInputEditText) inf.findViewById(R.id.txtCustomerCCCD);
        txtSDT = (TextInputEditText) inf.findViewById((R.id.txtCustomerPhone));
        txtBD = (TextInputEditText) inf.findViewById(R.id.txtCustomerBD);
        txtGioiTinh = (TextInputEditText) inf.findViewById((R.id.txtCustomerGioiTinh));
//        txtGT = (AutoCompleteTextView) inf.findViewById(R.id.txtCustomerGioiTinh);
        txtmk = (TextInputEditText) inf.findViewById((R.id.txtMK));
    }

}
