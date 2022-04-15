package Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.orderflightapp.R;

import org.w3c.dom.Text;

import java.util.List;

import Model.HistoryModel;

public class HistoryAdapter extends ArrayAdapter<HistoryModel.Items> {
    Activity context;
    int resource;

    public HistoryAdapter (@Nullable Context context, int resource){
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @androidx.annotation.NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource, null);

        TextView txtHangVe = view.findViewById(R.id.txtLoaive);
        TextView txtGioDi = view.findViewById((R.id.txtGioDi_History));
        TextView txtNgayDi = view.findViewById(R.id.txtNgayDi_History);
        TextView txtCangDi = view.findViewById(R.id.txtCangDi_History);
        TextView txtCangDen = view.findViewById(R.id.txtCangDen_History);
        TextView txtTrangThai = view.findViewById(R.id.txtStatus);
        TextView txtGiaVe = view.findViewById(R.id.txtGiaVe_History);
        TextView txtNgayMua = view.findViewById(R.id.txtNgayMua_History);

        HistoryModel.Items lichsu = getItem(position);
        String loai = lichsu.getLoaive();
        if(loai.equals("0")){
            txtHangVe.setText("ClassicClass");
        } else if (loai.equals("1")) {
            txtHangVe.setText("BussinessClass");
        }
        Log.v("log:", txtHangVe.toString());
        txtGioDi.setText(lichsu.getGiobay());
        txtNgayDi.setText(lichsu.getNgaybay());
        txtCangDi.setText(lichsu.getCangdi());
        txtCangDen.setText((lichsu.getCangden()));
        String tinhtrang = lichsu.getTinhtrang();
        if(tinhtrang.equals("0")){
            txtTrangThai.setText("Chưa sử dụng");
        } else if (tinhtrang.equals("1")) {
            txtTrangThai.setText("Đã sử dụng");
        }
        txtNgayMua.setText(lichsu.getNgaymua());
        txtGiaVe.setText(lichsu.getTienve());

        return view;
    }
}
