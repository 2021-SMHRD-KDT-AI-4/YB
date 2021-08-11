package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_print_Search_list_Fail extends AppCompatActivity {


    private TextView tv_n_retry,  tv_search_fail, tv_fail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_search_list_fail);


        tv_n_retry = findViewById(R.id.tv_n_retry);
        tv_search_fail = findViewById(R.id.tv_search_fail);
        tv_fail = findViewById(R.id.tv_fail);

    }
}