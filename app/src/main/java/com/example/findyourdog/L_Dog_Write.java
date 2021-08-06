package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Write extends AppCompatActivity {

    private Button btn_l_dog_img, btn_l_dog_write;
    private ImageView img_menu;
    private TextView app_name4, tv_l_dog_write, tv_l_dog_infor, tv_l_dog_date, tv_l_dog_time, tv_l_dog_where, tv_l_dog_tel;
    private TextView tv_l_dog_simple, tv_l_dog_img, tv_l_dog_sex, tv_l_dog_birth, tv_l_dog_color, tv_l_dog_type;
    private TextView tv_l_dog_kg, tv_l_dog_feature, tv_l_dog_vital;
    private EditText edt_l_dog_kg, edt_l_dog_feature,edt_l_dog_sex, edt_l_dog_birth, edt_l_dog_color;
    private EditText edt_l_dog_type, edt_l_dog_date, edt_l_dog_time, edt_l_dog_where, edt_l_dog_tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write);

        btn_l_dog_img = findViewById(R.id.btn_l_dog_img);
        btn_l_dog_write = findViewById(R.id.btn_l_dog_write);
        img_menu = findViewById(R.id.img_menu);
        app_name4 = findViewById(R.id.tv_appname);
//        tv_l_dog_write = findViewById(R.id.tv_l_dog_write);
        tv_l_dog_infor = findViewById(R.id.tv_l_dog_infor);
        tv_l_dog_date = findViewById(R.id.tv_l_dog_date);
        tv_l_dog_time = findViewById(R.id.tv_l_dog_time);
        tv_l_dog_where = findViewById(R.id.tv_l_dog_where);
        tv_l_dog_tel = findViewById(R.id.tv_l_dog_tel);
        tv_l_dog_simple = findViewById(R.id.tv_l_dog_simple);
        tv_l_dog_img = findViewById(R.id.tv_l_dog_img);
        tv_l_dog_sex = findViewById(R.id.tv_l_dog_sex);
        tv_l_dog_birth = findViewById(R.id.tv_l_dog_birth);
        tv_l_dog_color = findViewById(R.id.tv_l_dog_color);
        tv_l_dog_type = findViewById(R.id.tv_l_dog_type);
        tv_l_dog_kg = findViewById(R.id.tv_l_dog_kg);
        tv_l_dog_feature = findViewById(R.id.tv_l_dog_feature);
        tv_l_dog_vital = findViewById(R.id.tv_l_dog_vital);
        edt_l_dog_kg = findViewById(R.id.edt_l_dog_kg);
        edt_l_dog_feature = findViewById(R.id.edt_l_dog_feature);
        edt_l_dog_sex = findViewById(R.id.edt_l_dog_sex);
        edt_l_dog_birth = findViewById(R.id.edt_l_dog_birth);
        edt_l_dog_color = findViewById(R.id.edt_l_dog_color);
        edt_l_dog_type = findViewById(R.id.edt_l_dog_type);
        edt_l_dog_date = findViewById(R.id.edt_l_dog_date);
        edt_l_dog_time = findViewById(R.id.edt_l_dog_time);
        edt_l_dog_where = findViewById(R.id.edt_l_dog_where);
        edt_l_dog_tel = findViewById(R.id.edt_l_dog_tel);

    }
}