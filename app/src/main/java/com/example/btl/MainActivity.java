package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,btnSignup;
    private EditText edt1,edt2;
    UserRepo userRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=(Button)findViewById(R.id.loginbtn);
        btnSignup=(Button) findViewById(R.id.signup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1 = (EditText) findViewById(R.id.email);
                edt2 = (EditText) findViewById(R.id.password);
                String email = edt1.getText().toString();
                String password = edt2.getText().toString();
                User user = new User(email,password);
                if(user.checkEmail()&&user.checkPassword()){
                    if (user.checkValidUser()){
                        Toast toast = Toast.makeText(MainActivity.this,"Đăng Nhập Thành Công!",Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent2 = new Intent(MainActivity.this, Home.class);
                        startActivity(intent2);
                    }
                    else {
                        Toast toast = Toast.makeText(MainActivity.this,"Tài Khoản hoặc Mật Khẩu không đúng!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this,"Đăng Nhập Không Thành Công!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}