package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Side_bar_nologin extends AppCompatActivity {

    private TextView app_name4, side_login, side_join, side_mypage, side_info, side_Q;
    private TextView side_1, side_2, side_3, side_4, side_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar_nologin);

        app_name4 = findViewById(R.id.tv_appname);
        side_login = findViewById(R.id.side_login);
        side_join = findViewById(R.id.side_join);
        side_mypage = findViewById(R.id.side_mypage);
        side_info = findViewById(R.id.side_info);
        side_Q = findViewById(R.id.side_Q);
        side_1 = findViewById(R.id.side_1);
        side_2 = findViewById(R.id.side_2);
        side_3 = findViewById(R.id.side_3);
        side_4 = findViewById(R.id.side_4);
        side_5 = findViewById(R.id.side_5);

        side_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.projectyb.Login.class);
                startActivity(intent);
            }
        });

        side_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.projectyb.Join.class);
                startActivity(intent);
            }
        });

        side_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        side_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        side_Q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}