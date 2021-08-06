package com.example.findyourdog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Question extends AppCompatActivity {

    private ImageView img_menu, img_bar1, img_bar2, img_bar3, img_bar4, img_bar5, img_bar6;
    private TextView tv_appname, tv_Q, tv_q1, tv_q2, tv_q3, tv_q4, tv_q5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        img_menu = findViewById(R.id.img_menu);
        tv_appname = findViewById(R.id.tv_appname);
        tv_Q = findViewById(R.id.tv_Q);
        img_bar1 = findViewById(R.id.img_bar1);
        img_bar2 = findViewById(R.id.img_bar2);
        img_bar3 = findViewById(R.id.img_bar3);
        img_bar4 = findViewById(R.id.img_bar4);
        img_bar5 = findViewById(R.id.img_bar5);
        img_bar6 = findViewById(R.id.img_bar6);
        tv_q1 = findViewById(R.id.tv_q1);
        tv_q2 = findViewById(R.id.tv_q2);
        tv_q3 = findViewById(R.id.tv_q3);
        tv_q4 = findViewById(R.id.tv_q4);
        tv_q5 = findViewById(R.id.tv_q5);

    }
}