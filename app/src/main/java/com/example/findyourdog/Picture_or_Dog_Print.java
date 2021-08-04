package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Picture_or_Dog_Print extends AppCompatActivity {

    private ImageView img_menu;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView app_name4, tv_nose_result_go, tv_picture_result_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_or_dog_print);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        app_name4 = findViewById(R.id.tv_appname);
        tv_nose_result_go = findViewById(R.id.tv_nose_result_go);
        tv_picture_result_go = findViewById(R.id.tv_picture_result_go);


    }
}