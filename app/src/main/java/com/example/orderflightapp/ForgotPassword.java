package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import InterfaceReponsitory.Methods;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {
    TaiKhoanModel.Items taikhoan;

    TextInputEditText txtUserName,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        txtUserName = findViewById(R.id.txtCCRe);

    }

    public void getTK(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<TaiKhoanModel> call = methods.GetTaiKhoan();
        call.enqueue(new Callback<TaiKhoanModel>() {
            @Override
            public void onResponse(Call<TaiKhoanModel> call, Response<TaiKhoanModel> response) {
                List<TaiKhoanModel.Items> data = response.body().getItems();
                String UserName = txtUserName.getText().toString();


                for (int i=0;i<data.size();i++){
                    if (UserName.equals(data.get(i).getCancuoc())){
                        taikhoan = data.get(i);
                        String pass = taikhoan.getMatkhau();
                        Toast.makeText(getApplicationContext(), "Mật khẩu của bạn là:"+pass, Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<TaiKhoanModel> call, Throwable t) {

            }
        });

    }

    public void TakePass(View view) {
        getTK();
    }

    public void GoToHome(View view) {
        Intent i = new Intent(ForgotPassword.this, LoginActivity.class);
        startActivity(i);
    }
}
