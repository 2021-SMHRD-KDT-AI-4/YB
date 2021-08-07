package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Write2 extends AppCompatActivity {

  private EditText edt_l_sex, edt_l_birth, edt_l_color, edt_l_type, edt_l_kg, edt_l_feature;
  private Button btn_l_picture_plus,btn_l_enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write2);

        edt_l_sex = findViewById(R.id.edt_l_sex);
        edt_l_birth = findViewById(R.id.edt_l_birth);
        edt_l_color = findViewById(R.id.edt_l_color);
        edt_l_type =findViewById(R.id.edt_l_type);
        edt_l_kg = findViewById(R.id.edt_l_kg);
        edt_l_feature = findViewById(R.id.edt_f_feature);
        btn_l_enroll = findViewById(R.id.btn_f_enroll);
        btn_l_picture_plus = findViewById(R.id.btn_f_picture_plus);





    }
}