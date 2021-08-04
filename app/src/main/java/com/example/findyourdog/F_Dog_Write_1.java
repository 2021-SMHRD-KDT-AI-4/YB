package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class F_Dog_Write_1 extends AppCompatActivity {

    private TextView app_name4, tv_info, tv_tel, tv_date, tv_where, tv_img, tv_time;
    private TextView tv_star6, tv_star7, tv_star8, tv_star9, tv_star10;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_plus, btn_ok;
    private EditText edt_find, edt_tel, edt_where, edt_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_1);

        app_name4 = findViewById(R.id.tv_appname);
        tv_info = findViewById(R.id.tv_info);
        tv_tel = findViewById(R.id.tv_tel);
        tv_date = findViewById(R.id.tv_date);
        tv_where = findViewById(R.id.tv_where);
        tv_img = findViewById(R.id.tv_img);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_plus = findViewById(R.id.btn_plus);
        btn_ok = findViewById(R.id.btn_ok);
        edt_find = findViewById(R.id.edt_find);
        edt_tel = findViewById(R.id.edt_tel);
        edt_where = findViewById(R.id.edt_time);
        tv_time = findViewById(R.id.tv_time);
        edt_time = findViewById(R.id.edt_time);
        tv_star6 = findViewById(R.id.tv_star6);
        tv_star7 = findViewById(R.id.tv_star7);
        tv_star8 = findViewById(R.id.tv_star8);
        tv_star9 = findViewById(R.id.tv_star9);
        tv_star10 = findViewById(R.id.tv_star10);


    }
}