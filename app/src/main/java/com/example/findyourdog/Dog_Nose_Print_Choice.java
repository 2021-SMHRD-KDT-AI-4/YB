package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_Print_Choice extends AppCompatActivity {

    private ImageView img_menu, img_nose1, img_nose2;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_want_find;
    private TextView tv_appname, tv_dog_nose_print_choice, tv_img1_name, tv_img2_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_choice);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_nose1 = findViewById(R.id.img_nose1);
        img_nose2 = findViewById(R.id.img_nose2);
        btn_want_find = findViewById(R.id.btn_want_find);
        tv_appname = findViewById(R.id.tv_appname);
        tv_dog_nose_print_choice = findViewById(R.id.tv_dog_nose_print_choice);
        tv_img1_name = findViewById(R.id.tv_img1_name);
        tv_img2_name = findViewById(R.id.tv_img2_name);
    }
}