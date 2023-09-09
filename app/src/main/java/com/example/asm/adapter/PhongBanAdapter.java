package com.example.asm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.model.PhongBan;

import java.util.ArrayList;

public class PhongBanAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<PhongBan> list;

    public PhongBanAdapter(Context context, ArrayList<PhongBan> list) {
        this.context = context;
        this.list = list;
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
        View view1 = inflater.inflate(R.layout.item_lvphongban, viewGroup, false);

        TextView txtTenPb = view1.findViewById(R.id.txtPhongBan);
        ImageView imgPb = view1.findViewById(R.id.imgPhongban);

        txtTenPb.setText(list.get(i).getTenPb());
        imgPb.setImageResource(list.get(i).getImgPhongban());

        return view1;
    }
}
