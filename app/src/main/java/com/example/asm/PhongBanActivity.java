package com.example.asm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.asm.adapter.PhongBanAdapter;
import com.example.asm.model.PhongBan;

import java.util.ArrayList;

public class PhongBanActivity extends AppCompatActivity {

    private ArrayList<PhongBan> list;
    private ListView listViewPb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_ban);

        Toolbar toolbar = findViewById(R.id.toolBarPb);
        SearchView searchViewPB = findViewById(R.id.searchPB);
        listViewPb = findViewById(R.id.lvPb);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Phòng Ban");

        loadData(getDSPB());

        searchViewPB.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                ArrayList<PhongBan> list1 = new ArrayList<>();

                for (PhongBan phongBan : getDSPB()){
                    if(phongBan.getTenPb().toLowerCase().contains(s.toLowerCase())){
                        list1.add(phongBan);
                    }
                }

                loadData(list1);

                return false;
            }
        });

    }

    public void loadData(ArrayList<PhongBan> list){
        PhongBanAdapter adapter = new PhongBanAdapter(PhongBanActivity.this, list);
        listViewPb.setAdapter(adapter);
    }

    public ArrayList<PhongBan> getDSPB(){
        list = new ArrayList<>();
        list.add(new PhongBan(R.drawable.ic_phongban, "Nhân sự"));
        list.add(new PhongBan(R.drawable.ic_phongban, "Hành Chính"));
        list.add(new PhongBan(R.drawable.ic_phongban, "Đào tạo"));

        return list;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return onOptionsItemSelected(item);
    }
}