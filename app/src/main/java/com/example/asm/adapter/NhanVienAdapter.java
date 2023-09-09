package com.example.asm.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;

import com.example.asm.EditActivity;
import com.example.asm.R;
import com.example.asm.model.NhanVien;

import java.util.ArrayList;

public class NhanVienAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NhanVien> list;
    private ActivityResultLauncher<Intent> myLaucher;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> list, ActivityResultLauncher<Intent> myLaucher) {
        this.context = context;
        this.list = list;
        this.myLaucher = myLaucher;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view1 = inflater.inflate(R.layout.item_lvnhanvien, viewGroup, false);

        TextView txtMaNv = view1.findViewById(R.id.txtMaNv);
        TextView txtHoTen = view1.findViewById(R.id.txtHoTen);
        TextView txtTenPb = view1.findViewById(R.id.txtTenPhongBan);

        ImageView imgEdit = view1.findViewById(R.id.btnEdit);
        ImageView imgDelete = view1.findViewById(R.id.btnDelete);


        txtMaNv.setText(list.get(i).getMaNv());
        txtHoTen.setText(list.get(i).getHoTen());
        txtTenPb.setText(list.get(i).getTenPb());

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maNv = txtMaNv.getText().toString();
                String tenNv = txtHoTen.getText().toString();
                String tenPb = txtTenPb.getText().toString();

                Intent intent = new Intent(context, EditActivity.class);

                Bundle bundle = new Bundle();
                NhanVien nhanVien = new NhanVien(maNv, tenNv, tenPb);
                bundle.putSerializable("nhanvien2", nhanVien);
                bundle.putInt("id", i);
                intent.putExtras(bundle);

                myLaucher.launch(intent);
            }
        });



        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
            }
        });

        return view1;
    }
}
