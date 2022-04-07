package com.example.orderflightapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Adapter.ChuyenbayAdapter;
import Model.ChuyenBayModel;

public class ListBooking extends AppCompatActivity {

    List<ChuyenBayModel.Items> ListCB;
    ChuyenbayAdapter chuyenBayAdapter;
    ListView lv;
    TextView txtSL;
    int SL_HanhKhach =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_booking);
        lv=findViewById(R.id.lv);
        txtSL = findViewById(R.id.txtSLNguoi);

        chuyenBayAdapter = new ChuyenbayAdapter(ListBooking.this, R.layout.items_booking);
    }

    public void GetChuyenBay(){
        for (int i=0;i<ListCB.size();i++){
            chuyenBayAdapter.add(ListCB.get(i));
        }

        lv.setAdapter(chuyenBayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChuyenBayModel.Items item = (ChuyenBayModel.Items) parent.getItemAtPosition(position);
                Intent i = new Intent(ListBooking.this, BookingDetailsActivity.class);

                i.putExtra("ChuyenBayDaChon", item);
                i.putExtra("SL_HanhKhach", SL_HanhKhach);

                startActivity(i);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        ListCB = new ArrayList<>();
        ListCB = (ArrayList<ChuyenBayModel.Items>) getIntent().getSerializableExtra("ListCB");
        Intent mIntent = getIntent();
        SL_HanhKhach = mIntent.getIntExtra("SL_HanhKhach",0);

        String SoLuong = SL_HanhKhach + " HÀNH KHÁCH " ;
        txtSL.setText(SoLuong);

        if (ListCB == null) Toast.makeText(getApplicationContext(), "Không tìm thấy chuyến bay nào !", Toast.LENGTH_LONG).show();
        chuyenBayAdapter.clear();
        lv.setAdapter(null);

        GetChuyenBay();
    }
}
