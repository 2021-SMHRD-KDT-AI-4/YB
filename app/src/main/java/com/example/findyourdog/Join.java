package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Join extends AppCompatActivity {

    private ImageView img_menu;
    private TextView app_name1, tv_join, tv_id1, tv_pw1, tv_name1, tv_tel1, tv_add1;
    private EditText tv_id2, tv_pw2, tv_name2, tv_tel2, tv_add2;
    private Button btn_check, btn_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        app_name1 = findViewById(R.id.app_name1);
        tv_join = findViewById(R.id.tv_join);
        tv_id1 = findViewById(R.id.tv_id1);
        tv_pw1 = findViewById(R.id.tv_pw1);
        tv_name1 = findViewById(R.id.tv_name1);
        tv_tel1 = findViewById(R.id.tv_tel1);
        tv_id2 = findViewById(R.id.tv_id2);
        tv_pw2 = findViewById(R.id.tv_pw2);
        tv_name2 = findViewById(R.id.tv_name2);
        tv_tel2 = findViewById(R.id.tv_tel2);
        tv_add1 = findViewById(R.id.tv_add1);
        tv_add2 = findViewById(R.id.tv_add2);
        btn_join = findViewById(R.id.btn_join);
        btn_check = findViewById(R.id.btn_check);

    }
}