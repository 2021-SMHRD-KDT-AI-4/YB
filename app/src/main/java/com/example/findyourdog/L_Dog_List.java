package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_List extends AppCompatActivity {

    private ImageView img_menu, img_l_dog_1, img_l_dog_2, img_l_dog_3, img_l_dog_4;
    private TextView app_name4, tv_l_dog1, tv_l_dog2, tv_l_dog3, tv_l_dog4;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_list);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_menu = findViewById(R.id.img_menu);
        img_l_dog_1 = findViewById(R.id.img_l_dog_1);
        img_l_dog_2 = findViewById(R.id.img_l_dog_2);
        img_l_dog_3 = findViewById(R.id.img_l_dog_3);
        img_l_dog_4 = findViewById(R.id.img_l_dog_4);
        app_name4 = findViewById(R.id.tv_appname);
        tv_l_dog1 = findViewById(R.id.tv_l_dog1);
        tv_l_dog2 = findViewById(R.id.tv_l_dog2);
        tv_l_dog3 = findViewById(R.id.tv_l_dog3);
        tv_l_dog4 = findViewById(R.id.tv_l_dog1);



    }
}