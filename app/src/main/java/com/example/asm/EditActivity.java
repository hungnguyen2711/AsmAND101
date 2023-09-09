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

public class EditActivity extends AppCompatActivity {
    private String tenPb = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextInputEditText edManv = findViewById(R.id.edMaNv1);
        TextInputEditText edTenNv = findViewById(R.id.edTenNhanVien1);
        Spinner spnTenPb = findViewById(R.id.spnTenPhongBan1);
        Button btnSua = findViewById(R.id.btnSua);

        ArrayList<PhongBan> list = new PhongBanActivity().getDSPB();
        SpinnerPBAdapter adapter = new SpinnerPBAdapter(EditActivity.this, list);
        spnTenPb.setAdapter(adapter);

        spnTenPb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tenPb = list.get(i).getTenPb();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        NhanVien nhanVien  = (NhanVien) bundle.getSerializable("nhanvien2");
        int id = bundle.getInt("id");

        edManv.setText(nhanVien.getMaNv());
        edTenNv.setText(nhanVien.getHoTen());

        int viTri = -1;
        for (int i = 0; i <list.size(); i++){
            if(list.get(i).getTenPb().equals(nhanVien.getTenPb())){
                viTri = i;
                break;
            }
        }
        spnTenPb.setSelection(viTri);


        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maNv = edManv.getText().toString();
                String tenNv = edTenNv.getText().toString();

                NhanVien nhanVien1 = new NhanVien(maNv, tenNv, tenPb);

                Intent intent1 = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("nhanvien3", nhanVien1);
                bundle1.putInt("id1", id);
                intent1.putExtras(bundle1);
                setResult(2, intent1);
                finish();
            }
        });
    }
}