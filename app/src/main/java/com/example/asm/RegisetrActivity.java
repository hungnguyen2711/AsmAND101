package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisetrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisetr);

        TextInputEditText edUserName = findViewById(R.id.edUserName);
        TextInputEditText edPass = findViewById(R.id.edPass);
        TextInputEditText edRepass = findViewById(R.id.edRepass);
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnTrove = findViewById(R.id.btnTrove);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userRegister = edUserName.getText().toString();
                String passRegister = edPass.getText().toString();
                String rePassRegister = edRepass.getText().toString();


                if (userRegister.equals("") || passRegister.equals("") || rePassRegister.equals("")){
                    if (userRegister.equals("")){
                        edUserName.setError("Vui lòng nhập tên đăng nhập");
                    }
                    if (passRegister.equals("")){
                        edPass.setError("Vui lòng nhập mật khẩu");
                    }
                    if (rePassRegister.equals("")){
                        edRepass.setError("Vui lòng nhập lại mật khẩu");
                    }
                } else if (!rePassRegister.equals(passRegister)){
                    Toast.makeText(RegisetrActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();

                    bundle.putString("userRegister", userRegister);
                    bundle.putString("passRegister", passRegister);
                    bundle.putString("rePassRegister", rePassRegister);

                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                }
            }
        });

        btnTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}