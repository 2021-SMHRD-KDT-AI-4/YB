package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_print_Search_list_Success extends AppCompatActivity {

    private ImageView img_menu, img_success;
    private TextView tv_appname, tv_search_success, tv_call_shelter, tv_find, tv_shelter_name1;
    private TextView tv_shelter_name2, tv_shelter_add1, tv_shelter_add2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_search_list_success);


        img_success = findViewById(R.id.img_success);
        tv_appname = findViewById(R.id.tv_appname);
        tv_search_success = findViewById(R.id.tv_search_success);
        tv_call_shelter = findViewById(R.id.tv_call_shelter);
        tv_find = findViewById(R.id.tv_find);
        tv_shelter_name1 = findViewById(R.id.tv_shelter_name1);
        tv_shelter_name2 = findViewById(R.id.tv_shelter_name2);
        tv_shelter_add1 = findViewById(R.id.tv_shelter_add1);
        tv_shelter_add2 = findViewById(R.id.tv_shelter_add2);


    }
}