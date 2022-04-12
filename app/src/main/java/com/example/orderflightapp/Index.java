package com.example.orderflightapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import Model.TaiKhoanModel;

public class Index extends AppCompatActivity {

    TaiKhoanModel.Items TaiKhoan;
    TextView tenKH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        GetIdView();
//        GetData();
//        SetData();





//        Bundle b = i.getExtras();
//
//
//        if(b != null){
//            String j = (String) b.get("tenkh");
//            Log.v("log:",j);
//        }





        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentHome()).commit();
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

//    public void GetIdView(){
//        tenKH = findViewById(R.id.txtCustomer);
//    }
//    public void GetData(){
//        Intent i = getIntent();
//        TaiKhoan =(TaiKhoanModel.Items) getIntent().getSerializableExtra("s");
//    }
//    public void SetData(){
//        tenKH.setText(TaiKhoan.getTenkh());
//    }

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
    }

    public void LogOut(View view) {
        Intent intent =new Intent(Index.this, LoginActivity.class);
        startActivity(intent);
    }

    public void BuyForGroup(View view) {
    }
}
