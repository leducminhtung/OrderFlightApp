package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.orderflightapp.R;

import Model.ChuyenBayModel;

public class ChuyenbayAdapter extends ArrayAdapter<ChuyenBayModel.Items> {
    Activity context;
    int resource;

    public ChuyenbayAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource,null);

        TextView txtCangdi = view.findViewById(R.id.txtCangDi);
        TextView txtCangden = view.findViewById(R.id.txtCangDen);
        TextView txtGiodi = view.findViewById(R.id.txtGioDi);
        TextView txtGiatien = view.findViewById(R.id.txtPrice);
        TextView txtGiatien1 = view.findViewById(R.id.txtPrice);
        TextView txtThoiLuong = view.findViewById(R.id.txtThoiluong);
//        TextView txtTenCangDi = view.findViewById(R.id.txtTenCangDi);
//        TextView txtTenCangDen = view.findViewById(R.id.txtTenCangDen);

        ChuyenBayModel.Items chuyenBayModel =getItem(position);
        txtGiatien.setText(chuyenBayModel.getGv().replace(".00","")+"đ");

        txtCangdi.setText(chuyenBayModel.getMacangdi());
        txtCangden.setText(chuyenBayModel.getMacangden());
        txtGiodi.setText(chuyenBayModel.getGiobay());
        txtThoiLuong.setText(chuyenBayModel.getThoiluongcb() + "phút");
//        txtTenCangDi.setText(chuyenBayModel.getTencangdi());
//        txtTenCangDen.setText(chuyenBayModel.getTencangden());



        return view;
    }
}
