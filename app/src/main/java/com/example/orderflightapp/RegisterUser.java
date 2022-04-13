package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import InterfaceReponsitory.Methods;
import Model.AccountInsertModel;

import Model.CallbackResultModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterUser extends AppCompatActivity {

    TextInputEditText txtRe_UserName,txtRe_Password,txtRe_ConfirmPassword, txtRe_ten, txtRe_Email, txtRe_Sdt;
    AutoCompleteTextView ngaysinh, gioitinh;
    final Calendar BDCalendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_account);

        txtRe_UserName = findViewById(R.id.txtRe_UserName);
        txtRe_ten = findViewById(R.id.txtRe_ten);
        txtRe_Email = findViewById(R.id.txtRe_email);
        txtRe_Sdt = findViewById(R.id.txtRe_sdt);
        txtRe_Password = findViewById(R.id.txtRe_Password);
        txtRe_ConfirmPassword = findViewById(R.id.txtRe_ConfirmPassword);

        gioitinh = findViewById(R.id.txtRe_GT);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RegisterUser.this,
                R.layout.dropdown_items, getResources().getStringArray(R.array.gioitinh));
        gioitinh.setAdapter(arrayAdapter);

        ngaysinh = (AutoCompleteTextView) findViewById(R.id.txtRe_BD);
        DatePickerDialog.OnDateSetListener dateBD = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                BDCalendar.set(Calendar.DAY_OF_MONTH,day);
                BDCalendar.set(Calendar.MONTH,month);
                BDCalendar.set(Calendar.YEAR,year);
                updateLabel();
            }
        };
        ngaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterUser.this, dateBD, BDCalendar.get(Calendar.YEAR), BDCalendar.get(Calendar.MONTH), BDCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void updateLabel(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.SIMPLIFIED_CHINESE);
        ngaysinh.setText(dateFormat.format(BDCalendar.getTime()));
    }

    public void SaveAccount(View view) {
        final int[] check_UserNameExist = {1};
        String MatKhau = txtRe_Password.getText().toString();
        String MatKhauConfirm =txtRe_ConfirmPassword.getText().toString();
//        String Name = txtRe_ten.getText().toString();
//        String BD = ngaysinh.getText().toString();
//        String Email = txtRe_Email.getText().toString();
//        String GT = gioitinh.getText().toString();
//        String SDT = txtRe_Sdt.getText().toString();


        final Methods[] methodsGetDsTK ={getRetrofit().create(Methods.class)};
        Call<TaiKhoanModel> callLayDSHD = methodsGetDsTK[0].GetTaiKhoan();
        callLayDSHD.enqueue(new Callback<TaiKhoanModel>() {
            @Override
            public void onResponse(Call<TaiKhoanModel> call, Response<TaiKhoanModel> response) {
                List<TaiKhoanModel.Items> items = response.body().getItems();
                for(int i=0;i<items.size();i++){
                    if (txtRe_UserName.getText().toString().equals(items.get(i).getCancuoc())) {
                        Toast.makeText(getBaseContext(), "Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
                        check_UserNameExist[0] = -1;
                    }
                }
                if (MatKhau.equals(MatKhauConfirm) && check_UserNameExist[0] == 1 ) {
                    AccountInsertModel taiKhoanInsertModel = new AccountInsertModel();
                    taiKhoanInsertModel.setCANCUOC(txtRe_UserName.getText().toString());
                    taiKhoanInsertModel.setMATKHAU(txtRe_Password.getText().toString());
                    taiKhoanInsertModel.setEMAIL(txtRe_Email.getText().toString());
                    taiKhoanInsertModel.setTENKH(txtRe_ten.getText().toString());
                    taiKhoanInsertModel.setSDT(txtRe_Sdt.getText().toString());
                    String bd = ngaysinh.getText().toString();
                    taiKhoanInsertModel.setNGAYSINH(bd);
                    String GT = gioitinh.getText().toString();
                    if(GT.equals("Nam")){
                        taiKhoanInsertModel.setGIOITINH("0");
                    }else if(GT.equals("Nữ")){
                        taiKhoanInsertModel.setGIOITINH("1");
                    }


                    Methods methods = getRetrofit().create(Methods.class);
                    Call<CallbackResultModel> call2 = methods.InsertAccount(taiKhoanInsertModel);
                    call2.enqueue(new Callback<CallbackResultModel>() {
                        @Override
                        public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                            String status = response.body().getSTATUS_OUT();
                            if(status.equals("TRUE")){
                                Toast.makeText(getBaseContext(),"Tạo tài khoản thành công!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterUser.this,LoginActivity.class);
                                intent.putExtra("Taikhoandatao",taiKhoanInsertModel);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getBaseContext(),"Tạo tài khoản thất bại !",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                            Toast.makeText(getBaseContext(),"Tạo tài khoản thất bại !",Toast.LENGTH_SHORT).show();

                        }
                    });



                }else
                {
                    Toast.makeText(getBaseContext(),"Mật khẩu xác nhận không trùng khớp !",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<TaiKhoanModel> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Server gặp sự cố!",Toast.LENGTH_SHORT).show();
            }
        });


        }

    public void GoToHome(View view) {
        Intent i = new Intent(RegisterUser.this, LoginActivity.class);
        startActivity(i);
    }
}
