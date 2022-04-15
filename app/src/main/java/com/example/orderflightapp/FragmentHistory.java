package com.example.orderflightapp;

import static Model.RetrofitClient.getRetrofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import Adapter.HistoryAdapter;
import InterfaceReponsitory.Methods;
import Model.HistoryModel;
import Model.TaiKhoanModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHistory extends Fragment {
    ListView lv_history;
    HistoryAdapter historyAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.listview_history, container, false);

        lv_history = inf.findViewById(R.id.lv_history);
        historyAdapter = new HistoryAdapter(inf.getContext(), R.layout.items_history);
        return inf;
    }

    @Override
    public void onStart() {
        super.onStart();
        String cc = LoginActivity.TaiKhoan.getCancuoc();

        Methods method = getRetrofit().create(Methods.class);
        Call<HistoryModel> call = method.GetHistory(cc);
        call.enqueue(new Callback<HistoryModel>() {
            @Override
            public void onResponse(Call<HistoryModel> call, Response<HistoryModel> response) {
                List<HistoryModel.Items> items = response.body().getItems();
                for(int i =0; i<items.size();i++){
                    historyAdapter.add(items.get(i));
//                    for(HistoryModel.Items a : items){
//                        String loai = a.getLoaive();
//                        if(loai.equals("0")){
//                            .setText("ClassicClass");
//                        } else if (loai.equals("1")) {
//                            txtHangVe.setText("BussinessClass");
//                        }
//                    }

                }
                lv_history.setAdapter(historyAdapter);
            }

            @Override
            public void onFailure(Call<HistoryModel> call, Throwable t) {

            }
        });
    }
}
