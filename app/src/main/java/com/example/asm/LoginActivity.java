package com.example.asm;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private String userLogin, passLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnDangKy = findViewById(R.id.btnDangKy);
        TextInputEditText user = findViewById(R.id.edUserLogin);
        TextInputEditText pass = findViewById(R.id.edPassLogin);
        Button btnLogin = findViewById(R.id.btnLogin);
        CheckBox ckRemember = findViewById(R.id.ckRemember);

        SharedPreferences sharedPreference = getSharedPreferences("INFO", MODE_PRIVATE);
        boolean ckRemembetMe = sharedPreference.getBoolean("rememeber", false);

        if(ckRemembetMe){
            String user2 = sharedPreference.getString("user", "");
            String pass2 = sharedPreference.getString("pass", "");
            user.setText(user2);
            pass.setText(pass2);
            ckRemember.setChecked(ckRemembetMe);

            userLogin = user2;
            passLogin = pass2;
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = user.getText().toString();
                String pass1 = pass.getText().toString();

                if(user1.equals(userLogin) && pass1.equals(passLogin)){
                    if(ckRemember.isChecked()){
                        SharedPreferences sharedPreferences = getSharedPreferences("INFO", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("user", user1);
                        editor.putString("pass", pass1);
                        editor.putBoolean("rememeber", ckRemember.isChecked());
                        editor.apply();

                    }
                    Intent intent = new Intent(LoginActivity.this, TrangChuActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Sai thông tin đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisetrActivity.class);
                myLaucher.launch(intent);
            }
        });

    }


    private ActivityResultLauncher<Intent> myLaucher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 1){
                        Intent intent = result.getData();
                        Bundle bundle = intent.getExtras();

                        userLogin = bundle.getString("userRegister");
                        passLogin = bundle.getString("passRegister");
                    }
                }
            }
    );
}