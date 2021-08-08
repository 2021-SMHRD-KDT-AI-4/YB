package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class P_Dog_Detail extends AppCompatActivity {


    private Button  btn_shelter_place, btn_ask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_dog_detail);


        btn_shelter_place = findViewById(R.id.btn_shelter_place);
        btn_ask = findViewById(R.id.btn_ask);

    }
}