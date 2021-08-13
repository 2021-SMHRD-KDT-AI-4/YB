package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_Print_Choice_Shelter extends AppCompatActivity {

    private ImageView  img_nose_shelter, img_nose_shelter2, img_nose_shelter3, img_nose_shelter4;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_find_owner;
    private TextView tv_appname, tv_dog_nose_print_choice, tv_shelter1, tv_shelter2, tv_shelter3, tv_shelter4;
    private CheckBox cb_3, cb_4, cb_5, cb_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_choice_shelter);

//        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_nose_shelter = findViewById(R.id.img_nose_shelter);
        img_nose_shelter2 = findViewById(R.id.img_nose_shelter2);
        img_nose_shelter3 = findViewById(R.id.img_nose_shelter3);
        img_nose_shelter4 = findViewById(R.id.img_nose_shelter4);
        tv_appname = findViewById(R.id.tv_appname);
        tv_dog_nose_print_choice = findViewById(R.id.tv_dog_nose_print_choice);
//        img_menu = findViewById(R.id.img_menu);
        btn_find_owner = findViewById(R.id.btn_find_owner);
        tv_shelter1 = findViewById(R.id.tv_shelter1);
        tv_shelter2 = findViewById(R.id.tv_shelter2);
        tv_shelter3 = findViewById(R.id.tv_shelter3);
        tv_shelter4 = findViewById(R.id.tv_shelter4);
        cb_3 = findViewById(R.id.cb_3);
        cb_4 = findViewById(R.id.cb_4);
        cb_5 = findViewById(R.id.cb_5);
        cb_6 = findViewById(R.id.cb_6);
    }
}