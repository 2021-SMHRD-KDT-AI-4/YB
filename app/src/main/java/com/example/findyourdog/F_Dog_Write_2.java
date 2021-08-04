package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class F_Dog_Write_2 extends AppCompatActivity {

    private TextView app_name4, tv_info, tv_text, tv_birth, tv_color, tv_star1, tv_star2, tv_star3, tv_star4, tv_star5, tv_type, tv_kg, tv_sex, tv_feature;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_ok;
    private EditText edt_type, edt_birth, edt_color, edt_sex, edt_feature, edt_kg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_2);

        app_name4 = findViewById(R.id.tv_appname);
        tv_info = findViewById(R.id.tv_info);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_ok = findViewById(R.id.btn_ok);
        tv_text = findViewById(R.id.tv_text);
        tv_birth = findViewById(R.id.tv_birth);
        tv_color = findViewById(R.id.tv_color);
        tv_star1 = findViewById(R.id.tv_star1);
        tv_star2 = findViewById(R.id.tv_star2);
        tv_star3 = findViewById(R.id.tv_star3);
        tv_star4 = findViewById(R.id.tv_star4);
        tv_star5 = findViewById(R.id.tv_star5);
        tv_type = findViewById(R.id.tv_type);
        tv_kg = findViewById(R.id.tv_kg);
        tv_sex = findViewById(R.id.tv_sex);
        tv_feature = findViewById(R.id.tv_feature);
        edt_type = findViewById(R.id.edt_type);
        edt_birth = findViewById(R.id.edt_birth);
        edt_color = findViewById(R.id.edt_color);
        edt_sex = findViewById(R.id.edt_sex);
        edt_feature = findViewById(R.id.edt_feature);
        edt_kg = findViewById(R.id.edt_kg);



    }
}