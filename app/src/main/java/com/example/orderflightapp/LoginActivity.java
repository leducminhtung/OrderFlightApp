package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import InterfaceReponsitory.Methods;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public static TaiKhoanModel.Items TaiKhoan;

    TextView txtcustomer;
    TextInputEditText txtUserName,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);



    }

    public void LayTaiKhoan(){
        Methods methods = getRetrofit().create(Methods.class);
        Call<TaiKhoanModel> call = methods.GetTaiKhoan();
        call.enqueue(new Callback<TaiKhoanModel>() {
            @Override
            public void onResponse(Call<TaiKhoanModel> call, Response<TaiKhoanModel> response) {
                List<TaiKhoanModel.Items> data = response.body().getItems();
                ArrayList<TaiKhoanModel.Items> dscb_Found = new ArrayList<>();

                String UserName = txtUserName.getText().toString();
                String PassWord = txtPassword.getText().toString();

                boolean dangnhapthanhcong = false;

                for (int i=0;i<data.size();i++){
                    if (UserName.equals(data.get(i).getCancuoc()) && PassWord.equals(data.get(i).getMatkhau())){

                        dangnhapthanhcong = true;
                        TaiKhoan = data.get(i);
                        String s = TaiKhoan.getTenkh();
                        List<TaiKhoanModel.Items> dataKH = response.body().getItems();
                        Toast.makeText(getBaseContext(),"???? l???y th??ng tin c?? nh??n !",Toast.LENGTH_SHORT).show();


                        for (int j=0;j<dataKH.size();j++){
                            if (TaiKhoan.getCancuoc().equals(dataKH.get(j).getCancuoc())){
                                TaiKhoan = data.get(j);
                                Intent intent1 = new Intent(LoginActivity.this,Index.class);
                                intent1.putExtra("traKhachDaNhap", TaiKhoan);
                                intent1.putExtra("tenkh", s);
                                intent1.putExtra("taikhoan", TaiKhoan);
                                startActivity(intent1);
                                break;
                            }
                        }



                    }

                }
                if (dangnhapthanhcong == false) Toast.makeText(getBaseContext(),"????ng nh???p sai t??i kho???n ho???c m???t kh???u !",Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<TaiKhoanModel> call, Throwable t) {

            }
        });
    }

    public void SignIn(View view) {
        LayTaiKhoan();
    }

    public void GoForgotPass(View view) {
        Intent i = new Intent(LoginActivity.this, ForgotPassword.class);
        startActivity(i);
    }

    public void CreateAccount(View view) {
        Intent i = new Intent(LoginActivity.this, RegisterUser.class);
        startActivity(i);
    }
}

