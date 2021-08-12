package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_print_Search_list_Success_Shelter extends AppCompatActivity {

    private ImageView img_success_shelter;
    private TextView tv_appname, tv_search_success, tv_find_shelter, tv_call_owner;
    private TextView tv_owner_tel1, tv_owner_tel, tv_owner_name1, tv_owner_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_search_list_success_shelter);


        img_success_shelter = findViewById(R.id.img_success_shelter);
        tv_appname = findViewById(R.id.tv_appname);
        tv_search_success = findViewById(R.id.tv_search_success);
        tv_find_shelter = findViewById(R.id.tv_find_shelter);
        tv_call_owner = findViewById(R.id.tv_call_owner);
        tv_owner_tel = findViewById(R.id.tv_owner_tel1);
        tv_owner_tel1 = findViewById(R.id.tv_owner_tel);
        tv_owner_name1 = findViewById(R.id.tv_owner_name);
        tv_owner_name1 = findViewById(R.id.tv_owner_name1);

    }
}