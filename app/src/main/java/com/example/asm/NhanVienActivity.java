package com.example.asm;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.asm.adapter.NhanVienAdapter;
import com.example.asm.model.NhanVien;

import java.util.ArrayList;

public class NhanVienActivity extends AppCompatActivity {

    private ArrayList<NhanVien> list;
    private ListView listViewNv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        ImageView imgback = findViewById(R.id.imgBackNv);
        SearchView searchView = findViewById(R.id.searchNv);
        Button btnThemNv = findViewById(R.id.btnThemPhongNV);
        listViewNv = findViewById(R.id.lvThemNv);

        list = new ArrayList<>();
        list.add(new NhanVien("NV001","Nguyễn Văn B", "Hành chính"));
        list.add(new NhanVien("NV002","Nguyễn Văn C", "Nhân sự"));
        list.add(new NhanVien("NV003","Nguyễn Văn D", "Nhân sự"));
        list.add(new NhanVien("NV004","Nguyễn Văn E", "Đào tạo"));

        loadData1(list);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                ArrayList<NhanVien> list1 = new ArrayList<>();

                for (NhanVien nhanVien : list){
                    if (nhanVien.getMaNv().toLowerCase().contains(s.toLowerCase())){
                        list1.add(nhanVien);
                    }
                }

                loadData1(list1);

                return false;
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        btnThemNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NhanVienActivity.this, AddNhanVien.class);
                myLaucher.launch(intent);
            }
        });
    }

    public void loadData1(ArrayList<NhanVien> list){
        NhanVienAdapter adapter = new NhanVienAdapter(NhanVienActivity.this, list, myLaucher);
        listViewNv.setAdapter(adapter);
    }

    private ActivityResultLauncher<Intent> myLaucher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 1){
                            Intent intent = result.getData();
                            Bundle bundle = intent.getExtras();

                            NhanVien nhanVien = (NhanVien) bundle.getSerializable("sinhvien1");
                            list.add(nhanVien);
                            loadData1(list);
                        }

                        if (result.getResultCode() == 2){
                            Intent intent =result.getData();
                            Bundle bundle = intent.getExtras();

                            NhanVien nhanVien = (NhanVien) bundle.getSerializable("nhanvien3");
                            int id = bundle.getInt("id1");
                            list.set(id, nhanVien);
                            loadData1(list);
                        }
                }
            }
    );

}