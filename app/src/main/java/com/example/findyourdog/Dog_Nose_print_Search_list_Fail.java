package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_print_Search_list_Fail extends AppCompatActivity {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, tv_n_retry;
    private TextView tv_appname, tv_search_fail, tv_fail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_search_list_fail);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        tv_n_retry = findViewById(R.id.tv_n_retry);
        tv_appname = findViewById(R.id.tv_appname);
        tv_search_fail = findViewById(R.id.tv_search_fail);
        tv_fail = findViewById(R.id.tv_fail);

    }
}