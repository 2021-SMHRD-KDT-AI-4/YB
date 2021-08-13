package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Picture_Search_Result extends AppCompatActivity {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_p_retry;
    private TextView app_name4, tv_picture, tv_fail2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_search_result);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        app_name4 = findViewById(R.id.tv_appname);
        tv_picture = findViewById(R.id.tv_p_result);
        tv_fail2 = findViewById(R.id.tv_p_fail);


    }
}