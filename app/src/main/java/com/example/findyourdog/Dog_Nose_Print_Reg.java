package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_Print_Reg extends AppCompatActivity {

    private ImageView img_menu, img_dog_nose_print, img_dog_nose_print2, img_dog_nose_print3;
    private ImageView img_dog_nose_print4, img_dog_nose_print5;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_dog_nose_print_reg;
    private TextView tv_appname, tv_dog_nose_print_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_reg);

//        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_dog_nose_print = findViewById(R.id.img_dog_nose_print);
        img_dog_nose_print2 = findViewById(R.id.img_dog_nose_print2);
        img_dog_nose_print3 = findViewById(R.id.img_dog_nose_print3);
        img_dog_nose_print4 = findViewById(R.id.img_dog_nose_print4);
        img_dog_nose_print5 = findViewById(R.id.img_dog_nose_print5);
        btn_dog_nose_print_reg = findViewById(R.id.btn_dog_nose_print_reg);
        tv_appname = findViewById(R.id.tv_appname);
        tv_dog_nose_print_reg = findViewById(R.id.tv_dog_nose_print_reg);


    }
}