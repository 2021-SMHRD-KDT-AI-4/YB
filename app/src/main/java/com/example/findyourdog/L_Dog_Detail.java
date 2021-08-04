package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Detail extends AppCompatActivity {

    private ImageView img_menu, img_l_dog_detail_img;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView tv_appname, tv_l_dog_info, tv_l_dog_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_detail);

        img_l_dog_detail_img = findViewById(R.id.img_l_dog_detail_img);
        tv_l_dog_info = findViewById(R.id.tv_l_dog_info);
        tv_l_dog_now = findViewById(R.id.tv_l_dog_now);
        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        tv_appname = findViewById(R.id.tv_appname);


    }
}