package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class P_Dog_Detail extends AppCompatActivity {

    private ImageView img_menu, img_p_dog_detail;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_shelter_place, btn_ask;
    private TextView tv_appname, tv_p_dog_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_dog_detail);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_p_dog_detail = findViewById(R.id.img_p_dog_detail);
        btn_shelter_place = findViewById(R.id.btn_shelter_place);
        btn_ask = findViewById(R.id.btn_ask);
        tv_appname = findViewById(R.id.tv_appname);
        tv_p_dog_detail = findViewById(R.id.tv_p_dog_detail);
    }
}