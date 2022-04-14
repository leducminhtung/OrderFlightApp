package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Helper.AppInfo;
import Helper.CreateOrder;
import InterfaceReponsitory.Methods;
import Model.CallbackResultModel;
import Model.CangModel;
import Model.ChuyenBayModel;
import Model.PhieuMuaVeInsertModel;
import Model.PhieuMuaVeModel;
import Model.VeInsertModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.zalopay.sdk.Environment;
import vn.zalopay.sdk.ZaloPayError;
import vn.zalopay.sdk.ZaloPaySDK;
import vn.zalopay.sdk.listeners.PayOrderListener;

public class BookingDetailsActivity extends AppCompatActivity {

    ChuyenBayModel.Items chuyenbaydachon;
    TextView txtTenCangDi,txtTenCangDen,txtNgayGioDi, txtThoiLuongBay, txtSLHK, txtGiaTienHK, txtTongTien, txtTrungChuyen, txtTGDung;
    LinearLayout lnr_details_hk;
    int slHK = 0;
    int flag = 0;
    List<CangModel.Items> cangBayAdapter = new ArrayList<>();
    String thanhtoan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_booking);
        chuyenbaydachon = (ChuyenBayModel.Items) getIntent().getSerializableExtra("ChuyenBayDaChon");
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        ZaloPaySDK.init(AppInfo.APP_ID, Environment.SANDBOX);

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

    public void ThanhtoanZalo(){
        Double giatien;
        Double sl;
        Double tong;
        giatien = Double.valueOf(chuyenbaydachon.getGv());
        sl = Double.valueOf(slHK);
        tong = giatien * sl;

        CreateOrder orderApi = new CreateOrder();
        try {
            JSONObject data = orderApi.createOrder(tong.toString().replace(".0",""));
            String code = data.getString("returncode");

            if (code.equals("1")) {

                String token = data.getString("zptranstoken");

                ZaloPaySDK.getInstance().payOrder(BookingDetailsActivity.this, token, "demozpdk://app", new PayOrderListener() {
                    @Override
                    public void onPaymentSucceeded(final String transactionId, final String transToken, final String appTransID) {
                        //Toast.makeText(BookingDetailsActivity.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookingDetailsActivity.this, Index.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onPaymentCanceled(String zpTransToken, String appTransID) {
                        Toast.makeText(BookingDetailsActivity.this, "Thanh toán bị hủy", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPaymentError(ZaloPayError zaloPayError, String zpTransToken, String appTransID) {
                        Toast.makeText(BookingDetailsActivity.this, "Thanh toán thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
//        txtThoiLuongBay.setText(chuyenbaydachon.getTenmb());
        txtSLHK.setText(String.valueOf(slHK));
        txtGiaTienHK.setText(chuyenbaydachon.getGv());
        if(chuyenbaydachon.getThoigiandung() == null){
            txtTGDung.setVisibility(View.GONE);
        }else{
            txtTGDung.setText(chuyenbaydachon.getThoigiandung() + "phút");
        }
        if(chuyenbaydachon.getGhichu() == null){
            txtTrungChuyen.setVisibility(View.GONE);
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

    public void GoToPay(View view) {

        Methods methodsNhapPhieu = getRetrofit().create(Methods.class);
        PhieuMuaVeInsertModel phieu = new PhieuMuaVeInsertModel();
        phieu.setCANCUOC(LoginActivity.TaiKhoan.getCancuoc());
        phieu.setSLVE(txtSLHK.getText().toString());
        phieu.setTHANHTIEN(txtTongTien.getText().toString().replace("đ",""));
        Call<CallbackResultModel> call =methodsNhapPhieu.InsertPhieu(phieu);
        call.enqueue(new Callback<CallbackResultModel>() {
            @Override
            public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                String status = response.body().getSTATUS_OUT();
                String value = response.body().getVALUE_OUT();
                if(status.equals("TRUE")){
                    Toast.makeText(getBaseContext(), "Thêm danh sách hóa đơn thành công!" + value, Toast.LENGTH_SHORT).show();
                    Methods methodsLayPhieu = getRetrofit().create(Methods.class);
                    Call<PhieuMuaVeModel> callPhieu = methodsLayPhieu.GetPhieuMuaVe();
                    callPhieu.enqueue(new Callback<PhieuMuaVeModel>() {
                        @Override
                        public void onResponse(Call<PhieuMuaVeModel> call, Response<PhieuMuaVeModel> response) {
                            Toast.makeText(getBaseContext(),"Lấy danh sách hóa đơn!",Toast.LENGTH_SHORT).show();
                            List<PhieuMuaVeModel.Items> items = response.body().getItems();
                            VeInsertModel veInsertModel =new VeInsertModel();
//                            String limitth = "1000000";
//                            String limittg = "2000000";
                                if(chuyenbaydachon.getGv().equals("1000000")){
                                    veInsertModel.setMAPHEU(value);
                                    veInsertModel.setCANCUOC(LoginActivity.TaiKhoan.getCancuoc());
                                    veInsertModel.setMACB(chuyenbaydachon.getMacb());
                                    veInsertModel.setTIENVE(chuyenbaydachon.getGv());
                                    Methods methodVeTh =getRetrofit().create(Methods.class);
                                    Call<CallbackResultModel> callVeTH =methodVeTh.InsertVeTh(veInsertModel);
                                    callVeTH.enqueue(new Callback<CallbackResultModel>() {
                                        @Override
                                        public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                                            String status = response.body().getSTATUS_OUT();
                                            if(status.equals("TRUE")){
                                                ThanhtoanZalo();
                                                Toast.makeText(getBaseContext(), "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(BookingDetailsActivity.this, Index.class);
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                                            Toast.makeText(getBaseContext(), "Thanh toán thất bại!", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }else if(chuyenbaydachon.getGv().equals("2000000")){
                                    veInsertModel.setMAPHEU(value);
                                    veInsertModel.setCANCUOC(LoginActivity.TaiKhoan.getCancuoc());
                                    veInsertModel.setMACB(chuyenbaydachon.getMacb());
                                    veInsertModel.setTIENVE(chuyenbaydachon.getGv());
                                    Methods methodVeTG =getRetrofit().create(Methods.class);
                                    Call<CallbackResultModel> callVeTH =methodVeTG.InsertVeTG(veInsertModel);
                                    callVeTH.enqueue(new Callback<CallbackResultModel>() {
                                        @Override
                                        public void onResponse(Call<CallbackResultModel> call, Response<CallbackResultModel> response) {
                                            String status = response.body().getSTATUS_OUT();
                                            if(status.equals("TRUE")){
                                                ThanhtoanZalo();
                                                Toast.makeText(getBaseContext(), "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(BookingDetailsActivity.this, Index.class);
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<CallbackResultModel> call, Throwable t) {
                                            Toast.makeText(getBaseContext(), "Thanh toán thất bại!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }


                        @Override
                        public void onFailure(Call<PhieuMuaVeModel> call, Throwable t) {

                        }
                    });
                }else{
                    Toast.makeText(getBaseContext(), "Thêm phiếu mua vé thất bại!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CallbackResultModel> call, Throwable t) {

            }
        });
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ZaloPaySDK.getInstance().onResult(intent);
    }
}
