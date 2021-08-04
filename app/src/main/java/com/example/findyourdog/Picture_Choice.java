package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Picture_Choice extends AppCompatActivity {

    private ImageView img_menu, img_picture1, img_picture2, img_picture3, img_picture4;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_find;
    private TextView tv_appname, tv_picture_result, tv_pic1_info, tv_pic2_info;
    private TextView tv_pic3_info, tv_pic4_info;
    private CheckBox cb_7, cb_8, cb_9, cb_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_choice);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_picture1 = findViewById(R.id.img_picture1);
        img_picture2 = findViewById(R.id.img_picture2);
        img_picture3 = findViewById(R.id.img_picture3);
        img_picture4 = findViewById(R.id.img_picture4);
        btn_find = findViewById(R.id.btn_find);
        tv_appname = findViewById(R.id.tv_appname);
        tv_picture_result = findViewById(R.id.tv_picture_result);
        tv_pic1_info = findViewById(R.id.tv_pic1_info);
        tv_pic2_info = findViewById(R.id.tv_pci2_info);
        tv_pic3_info = findViewById(R.id.tv_pic3_info);
        tv_pic4_info = findViewById(R.id.tv_pic4_info);
        cb_7 = findViewById(R.id.cb_7);
        cb_8 = findViewById(R.id.cb_8);
        cb_9 = findViewById(R.id.cb_9);
        cb_10 = findViewById(R.id.cb_10);

    }
}