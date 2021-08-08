package com.example.findyourdog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Detail extends AppCompatActivity {

    private ImageView img_l_d_dog;
    private TextView l_d_sex,l_d_age,l_d_color,l_d_kind,l_d_kg,l_d_day,l_d_place,l_d_time,l_d_id,l_d_tel,l_d_etc,
                     tv_l_d_sex,tv_l_d_age,tv_l_d_color,tv_l_d_kind,tv_l_d_kg,tv_l_d_day,tv_l_d_place,tv_l_d_time,tv_l_d_id,tv_l_d_tel,tv_l_d_etc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_detail);


        tv_l_d_sex = findViewById(R.id.tv_l_d_sex);
        tv_l_d_age = findViewById(R.id.tv_l_d_age);
        tv_l_d_color = findViewById(R.id.tv_l_d_color);
        tv_l_d_kind = findViewById(R.id.tv_l_d_kind);
        tv_l_d_kg = findViewById(R.id.tv_l_d_kg);
        tv_l_d_day = findViewById(R.id.tv_l_d_day);
        tv_l_d_place = findViewById(R.id.tv_l_d_place);
        tv_l_d_time = findViewById(R.id.tv_l_d_time);
        tv_l_d_id = findViewById(R.id.tv_l_d_id);
        tv_l_d_tel = findViewById(R.id.tv_l_d_tel);
        tv_l_d_etc = findViewById(R.id.tv_l_d_etc);
        img_l_d_dog = findViewById(R.id.img_l_d_dog);



    }
}