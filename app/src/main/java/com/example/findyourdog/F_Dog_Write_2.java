package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class F_Dog_Write_2 extends AppCompatActivity {

    private TextView tv_f_dog_info,tv_vital,tv_f_birth,tv_f_color,tv_f_type,tv_f_sex,tv_f_feature,
                     tv_star1,tv_star2,tv_star3,tv_star4,tv_star5;
    private Button btn_f_enroll;
    private EditText edt_f_type, edt_f_birth, edt_f_color, edt_f_sex, edt_f_feature, edt_f_kg;
    private Spinner spn_f_breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_2);

        spn_f_breed = findViewById(R.id.spn_f_breed);
        edt_f_birth = findViewById(R.id.edt_f_birth);
        edt_f_color = findViewById(R.id.edt_f_color);
        edt_f_feature = findViewById(R.id.edt_f_feature);
        edt_f_sex = findViewById(R.id.edt_f_sex);
        edt_f_kg = findViewById(R.id.edt_f_kg);
        btn_f_enroll = findViewById(R.id.btn_f_next);




    }
}