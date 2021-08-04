package com.example.findyourdog;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Question_Result extends AppCompatActivity {

    private TextView app_name5, tv_Q, tv_Question, tv_bar7, tv_A1, tv_A2, tv_A3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_result);

        app_name5 = findViewById(R.id.app_name5);
        tv_Q = findViewById(R.id.tv_Q);
        tv_Question = findViewById(R.id.tv_Question);
        tv_bar7 = findViewById(R.id.tv_bar7);
        tv_A1 = findViewById(R.id.tv_A1);
        tv_A2 = findViewById(R.id.tv_A2);
        tv_A3 = findViewById(R.id.tv_A3);
    }
}