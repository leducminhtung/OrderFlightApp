package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import InterfaceReponsitory.Methods;
import Model.CallbackResultModel;
import Model.CustomerUpdateModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  Index extends AppCompatActivity {

    public static TaiKhoanModel.Items TaiKhoan;
    TextView tenKH, txtCustomerName, txtHangTV;
    TextInputEditText txtCC, txtEmail, txtSDT, txtBD, txtGioiTinh, txtMK, txtname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        TaiKhoan = (TaiKhoanModel.Items) getIntent().getSerializableExtra("taikhoan");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentHome()).commit();
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }


    public void GetIdView(){
        txtCustomerName =findViewById(R.id.txtCustomUserName);
        txtEmail = findViewById(R.id.txtCustomerEmail);
        txtSDT = findViewById((R.id.txtCustomerPhone));
        txtBD = findViewById(R.id.txtCustomerBD);
        txtGioiTinh = findViewById((R.id.txtCustomerGioiTinh));
        txtMK = findViewById(R.id.txtMK);
        txtname = findViewById((R.id.txtCustomerName));

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.menuHome:
                            selectedFragment = new FragmentHome();
                            break;
                        case R.id.menuAccount:
                            selectedFragment = new FragmentAccount();
                            break;
                        case R.id.menuHistory:
                            selectedFragment = new FragmentHistory();
                            break;
                        case R.id.menuSetting:
                            selectedFragment = new SettingsActivity.SettingsFragment();
                            break;
                }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public void GoToBooking(View view) {
        Intent intent = new Intent(Index.this, BookingActivity.class);
        startActivity(intent);
    }

    public void GoToCheckFlight(View view) {
    }

    public void GoToChangePass(View view) {
    }

    public void Update(View view) {
        GetIdView();
        CustomerUpdateModel cust =new CustomerUpdateModel();

        cust.setCANCUOC(LoginActivity.TaiKhoan.getCancuoc());
        String GT = txtGioiTinh.getText().toString();
        if(GT.equals("Nữ")){
            cust.setGIOITINH("1");
            LoginActivity.TaiKhoan.setGioitinh("1");
        }else if(GT.equals("Nam")){
            cust.setGIOITINH("0");
            LoginActivity.TaiKhoan.setGioitinh("0");
        }
        cust.setEMAIL(txtEmail.getText().toString());
        cust.setSDT(txtSDT.getText().toString());
        cust.setNGAYSINH(txtBD.getText().toString());
        cust.setMATKHAU(txtMK.getText().toString());
        cust.setTENKH(txtname.getText().toString());

        LoginActivity.TaiKhoan.setEmail(txtEmail.getText().toString());
        LoginActivity.TaiKhoan.setTenkh(txtname.getText().toString());
        LoginActivity.TaiKhoan.setSdt(txtSDT.getText().toString());
        LoginActivity.TaiKhoan.setNgaysinh(txtBD.getText().toString());
        LoginActivity.TaiKhoan.setMatkhau(txtMK.getText().toString());
//        LoginActivity.TaiKhoan.setGioitinh(txtGioiTinh.getText().toString());





        Methods methodsNhapKhach = getRetrofit().create(Methods.class);
        Call<CallbackResultModel> callNhapKhach = methodsNhapKhach.UpdateCust(cust);
        callNhapKhach.enqueue(new Callback<CallbackResultModel>() {
            @Override
            public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                String status = response.body().getSTATUS_OUT();
                if(status.equals("TRUE")){
                    Toast.makeText(getBaseContext(),"Đã lưu thông tin !",Toast.LENGTH_SHORT).show();
                    txtEmail.setText(LoginActivity.TaiKhoan.getEmail());
                    txtname.setText(LoginActivity.TaiKhoan.getTenkh());
                    txtSDT.setText(LoginActivity.TaiKhoan.getSdt());
                    txtBD.setText(LoginActivity.TaiKhoan.getNgaysinh());
                    txtGioiTinh.setText(LoginActivity.TaiKhoan.getGioitinh());
                    txtMK.setText(LoginActivity.TaiKhoan.getMatkhau());

                }else{
                    Toast.makeText(getBaseContext(),"Không lưu thông tin thành công !",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Không thể lưu thông tin !",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void LogOut(View view) {
        Intent intent =new Intent(Index.this, LoginActivity.class);
        startActivity(intent);
    }

    public void BuyForGroup(View view) {
    }
}
