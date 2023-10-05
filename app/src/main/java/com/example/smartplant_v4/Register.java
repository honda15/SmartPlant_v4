package com.example.smartplant_v4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Register extends AppCompatActivity {

    EditText user_data,passd_data,phone_data,email_data,remark_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findviews();
    }

    void findviews(){
        user_data = findViewById(R.id.et_user_data);
        passd_data = findViewById(R.id.et_passd_data);
        phone_data = findViewById(R.id.et_phone_data);
        email_data = findViewById(R.id.et_email_data);
        remark_data = findViewById(R.id.et_remark_data);
    }


    public void return_top(View view) {
        finish();
    }

    public void data_clear(View view) {
        user_data.setText("");
        passd_data.setText("");
        phone_data.setText("");
        email_data.setText("");
        remark_data.setText("");
    }

    public void data_build(View view) {
        String user_tmp = user_data.getText().toString();
        String password_tmp = passd_data.getText().toString();
        String phone_tmp = phone_data.getText().toString();
        String email_tmp = email_data.getText().toString();
        String remark_tmp = remark_data.getText().toString();
        //------------------------------------------------------------------------------------------
        if(user_tmp.equals("")||password_tmp.equals("")||phone_tmp.equals("")||email_tmp.equals("")||remark_tmp.equals("")){

            Toast.makeText(Register.this,"填寫資料不可為空",Toast.LENGTH_LONG).show();

            //------------------------------------------------------------------------------------------
        }else {

            // 創建 OkHttpClient 實例，用於發送 HTTP 請求
            OkHttpClient client = new OkHttpClient();

// 建立 FormBody 以將資料作為 POST 請求發送
            FormBody formBody = new FormBody.Builder()
                    .add("user", user_data.getText().toString()) // 將使用者資料添加到請求中
                    .add("password", passd_data.getText().toString()) // 將密碼資料添加到請求中
                    .add("phone", phone_data.getText().toString()) // 將電話資料添加到請求中
                    .add("email", email_data.getText().toString()) // 將電子郵件資料添加到請求中
                    .add("remark", remark_data.getText().toString()) // 將備註資料添加到請求中
                    .build();

// 創建一個使用 POST 方法的 HTTP 請求
            Request request = new Request.Builder()
                    .post(formBody) // 將請求主體設置為 FormBody
                    .build();

// 創建一個 Call 對象以異步執行請求
            Call call = client.newCall(request);

// 將請求加入佇列，並定義成功和失敗的回呼函數
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    // 處理請求失敗的情況
                    Log.d("message", e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    // 處理成功接收到回應的情況

                    // 在主執行緒上運行與 UI 有關的程式碼
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // 創建一個 AlertDialog 以向使用者顯示訊息
                            new AlertDialog.Builder(Register.this)
                                    .setTitle("帳號建立結果") // 設置對話框標題
                                    .setMessage("個人資料已建立") // 設置要顯示的訊息
                                    .setPositiveButton("回首頁", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // 定義點擊「回首頁」按鈕時要執行的操作

                                            // 創建一個意圖以導航至登錄活動
                                            Intent intent = new Intent(Register.this, Login.class);
                                            startActivity(intent); // 啟動登錄活動
                                        }
                                    })
                                    .show(); // 顯示 AlertDialog 給使用者
                        }
                    });
                }
            });
        }
    }
}
