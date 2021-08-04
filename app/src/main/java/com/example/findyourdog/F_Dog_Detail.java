package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class F_Dog_Detail extends AppCompatActivity {

    private ImageView img_menu, img_f_dog_1;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView app_name4, tv_witness, tv_f_dog_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_detail);

        img_menu = findViewById(R.id.img_menu);
        img_f_dog_1 = findViewById(R.id.img_f_dog_1);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        app_name4 = findViewById(R.id.tv_appname);
        tv_witness = findViewById(R.id.tv_witness);
        tv_f_dog_detail = findViewById(R.id.tv_f_dog_detail);

    }
}