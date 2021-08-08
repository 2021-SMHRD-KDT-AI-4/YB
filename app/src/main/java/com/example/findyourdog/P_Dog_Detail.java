package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class P_Dog_Detail extends AppCompatActivity {

    private TextView p_d_sex,p_d_kind,p_d_color,p_d_kg,p_d_neutering,p_d_place,p_d_feature,p_d_birth,
                     tv_p_d_sex,tv_p_d_kind,tv_p_d_color,tv_p_d_kg,tv_p_d_neutering,tv_p_d_place,tv_p_d_feature,tv_p_d_birth,
                     shelter_place, adopt_ask;

    private ImageButton imgbtn_shelter_place, imgbtn_adopt_ask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_dog_detail);


        tv_p_d_sex = findViewById(R.id.tv_p_d_sex);
        tv_p_d_kind = findViewById(R.id.tv_p_d_kind);
        tv_p_d_color = findViewById(R.id.tv_p_d_color);
        tv_p_d_kg = findViewById(R.id.tv_p_d_kg);
        tv_p_d_neutering = findViewById(R.id.tv_p_d_neutering);
        tv_p_d_place = findViewById(R.id.tv_p_d_place);
        tv_p_d_feature = findViewById(R.id.tv_p_d_feature);
        tv_p_d_birth = findViewById(R.id.tv_p_d_birth);
        imgbtn_shelter_place = findViewById(R.id.imgbtn_shelter_place);
        imgbtn_adopt_ask = findViewById(R.id.imgbtn_adopt_ask);

    }
}