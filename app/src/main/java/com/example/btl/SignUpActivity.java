package com.example.btl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private Button btnSignup;  //btnLogin;
    private EditText edt1,edt2,edt3;
    UserRepo userRepo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignup=(Button)findViewById(R.id.signupbtn);
        //btnLogin=(Button)findViewById(R.id.loginbtn);
        //btnLogin.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                //startActivity(intent);
          //  }
        //});
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1 = (EditText)findViewById(R.id.email);
                edt2 = (EditText)findViewById(R.id.password);
                edt3 = (EditText)findViewById(R.id.comfirmpass);
                String email = edt1.getText().toString();
                String password= edt2.getText().toString();
                String passwordcf= edt3.getText().toString();
                if (password.equals(passwordcf)){
                    User user= new User(email,password);
                    if (user.checkEmail()&&user.checkPassword()){
                        userRepo.addUser(user);
                        Toast toast = Toast.makeText(SignUpActivity.this,"Tạo Thành Công!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else{
                        Toast toast = Toast.makeText(SignUpActivity.this,"Tài khoản, mật khẩu không hợp lệ!",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else {
                    Toast toast = Toast.makeText(SignUpActivity.this,"Mật khẩu không trùng nhau!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}