package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class F_Dog_Detail extends AppCompatActivity {

    private ImageView img_f_d_dog;
    private TextView f_d_sex,f_d_age,f_d_color,f_d_kind,f_d_day,f_d_place,f_d_time,f_d_id,f_d_tel,f_d_etc,
            tv_f_d_sex,tv_f_d_age,tv_f_d_color,tv_f_d_kind,tv_f_d_day,tv_f_d_place,tv_f_d_time,tv_f_d_id,tv_f_d_tel,tv_f_d_etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_detail);

        tv_f_d_sex = findViewById(R.id.tv_f_d_sex);
        tv_f_d_age = findViewById(R.id.tv_f_d_age);
        tv_f_d_color = findViewById(R.id.tv_f_d_color);
        tv_f_d_kind = findViewById(R.id.tv_f_d_kind);
        tv_f_d_day = findViewById(R.id.tv_f_d_day);
        tv_f_d_place = findViewById(R.id.tv_f_d_place);
        tv_f_d_time = findViewById(R.id.tv_f_d_time);
        tv_f_d_id = findViewById(R.id.tv_f_d_id);
        tv_f_d_tel = findViewById(R.id.tv_f_d_tel);
        tv_f_d_etc = findViewById(R.id.tv_f_d_etc);
        img_f_d_dog = findViewById(R.id.img_f_d_dog);


    }
}