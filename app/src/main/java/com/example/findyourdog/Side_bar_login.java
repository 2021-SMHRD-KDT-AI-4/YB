package com.example.findyourdog;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Side_bar_login extends AppCompatActivity {

    private TextView app_name4, side_logout, side_join2, side_mypage2, side_info2, side_Q2;
    private TextView side_6, side_7, side_8, side_9, side_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar_login);

        app_name4 = findViewById(R.id.tv_appname);
        side_logout = findViewById(R.id.side_logout);
        side_join2 = findViewById(R.id.side_join2);
        side_mypage2 = findViewById(R.id.side_mypage2);
        side_info2 = findViewById(R.id.side_info2);
        side_Q2 = findViewById(R.id.side_Q2);
        side_6 = findViewById(R.id.side_6);
        side_7 = findViewById(R.id.side_7);
        side_8 = findViewById(R.id.side_8);
        side_9 = findViewById(R.id.side_9);
        side_10 = findViewById(R.id.side_10);

    }
}