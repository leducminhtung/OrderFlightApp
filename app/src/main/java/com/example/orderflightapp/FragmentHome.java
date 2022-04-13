package com.example.orderflightapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class FragmentHome extends Fragment {
    TextView txtcustomer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.activity_home, container, false);

        getViewId(inf);
        setData();
        return inf;
    }
    public void getViewId(View inf){
        txtcustomer = (TextView) inf.findViewById(R.id.txtCustomer);
    }
    public void setData(){
        txtcustomer.setText(LoginActivity.TaiKhoan.getTenkh());
    }


}
