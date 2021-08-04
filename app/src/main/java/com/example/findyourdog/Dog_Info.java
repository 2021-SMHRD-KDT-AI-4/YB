package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Info extends AppCompatActivity {
    //
    private ImageView img_menu, img_profile;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_dog_print, btn_profile_ok;
    private TextView tv_appname, tv_profile, tv_info_add, tv_info_color, tv_info_name;
    private TextView tv_info_sex, tv_info_type, tv_info_dogprint;
    private EditText edt_info_add, edt_info_sex, edt_info_type, edt_info_name, edt_info_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_info);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_dog_print = findViewById(R.id.btn_dog_print);
        btn_profile_ok = findViewById(R.id.btn_profile_ok);
        tv_appname = findViewById(R.id.tv_appname);
        img_profile = findViewById(R.id.img_profile);
        tv_profile = findViewById(R.id.tv_profile);
        tv_info_add = findViewById(R.id.tv_info_add);
        tv_info_color = findViewById(R.id.tv_info_color);
        tv_info_name = findViewById(R.id.tv_info_name);
        tv_info_sex = findViewById(R.id.tv_info_sex);
        tv_info_type = findViewById(R.id.tv_info_type);
        tv_info_dogprint = findViewById(R.id.tv_info_dogprint);
        edt_info_add = findViewById(R.id.edt_info_add);
        edt_info_sex = findViewById(R.id.edt_info_sex);
        edt_info_type = findViewById(R.id.edt_info_type);
        edt_info_name = findViewById(R.id.edt_info_name);
        edt_info_color = findViewById(R.id.edt_info_color);

    }
}