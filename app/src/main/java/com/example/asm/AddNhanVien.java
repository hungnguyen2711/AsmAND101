package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.example.asm.adapter.SpinnerPBAdapter;
import com.example.asm.model.NhanVien;
import com.example.asm.model.PhongBan;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class AddNhanVien extends AppCompatActivity {

    private String tenPb ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nhan_vien);

        TextInputEditText edMaNv = findViewById(R.id.edMaNv);
        TextInputEditText edTenNhanVien = findViewById(R.id.edTenNhanVien);
        Spinner spnNv = findViewById(R.id.spnTenPhongBan);

        Button btnThemMoi = findViewById(R.id.btnThemMoi);
        ArrayList<PhongBan> list = new PhongBanActivity().getDSPB();
        SpinnerPBAdapter adapter = new SpinnerPBAdapter(AddNhanVien.this, list);
        spnNv.setAdapter(adapter);

        spnNv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tenPb = list.get(i).getTenPb();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnThemMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maNv = edMaNv.getText().toString();
                String tenNv = edTenNhanVien.getText().toString();

                NhanVien nhanVien = new NhanVien(maNv, tenNv, tenPb);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("sinhvien1", nhanVien);
                intent.putExtras(bundle);
                setResult(1, intent);
                finish();
            }
        });



    }
}