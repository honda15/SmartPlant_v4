package com.example.smartplant_v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText Edit_Email,Edit_Password;
    String password,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Edit_Email =findViewById(R.id.edit_email);
        Edit_Password = findViewById(R.id.edit_password);
    }

    public void btn_login(View view) {
        password = Edit_Password.getText().toString();
        email = Edit_Email.getText().toString();

//        if(password == null || email == null){
//            Toast.makeText(this,"請輸入密碼和電子郵件",Toast.LENGTH_LONG).show();
//        }
//        if (password == "1234" && email == "mylife4451@gmail.com"){
            Intent intent = new Intent(this, Function_UI.class);
            startActivity(intent);
//        }

    }


    public void btn_register2(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}