package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_print_Search_list_Success_Shelter extends AppCompatActivity {

    private ImageView img_menu, img_success_shelter;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView tv_appname, tv_search_success, tv_find_shelter, tv_call_owner;
    private TextView tv_owner_tel1, tv_owner_tel2, tv_owner_name1, tv_owner_name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_search_list_success_shelter);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_success_shelter = findViewById(R.id.img_success_shelter);
        tv_appname = findViewById(R.id.tv_appname);
        tv_search_success = findViewById(R.id.tv_search_success);
        tv_find_shelter = findViewById(R.id.tv_find_shelter);
        tv_call_owner = findViewById(R.id.tv_call_owner);
        tv_owner_tel1 = findViewById(R.id.tv_owner_tel1);
        tv_owner_tel2 = findViewById(R.id.tv_owner_tel2);
        tv_owner_name1 = findViewById(R.id.tv_owner_name1);
        tv_owner_name2 = findViewById(R.id.tv_owner_name2);

    }
}