package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class P_Dog_list extends AppCompatActivity {

    private ImageView img_menu, img_p_dog1, img_p_dog2, img_p_dog3, img_p_dog4;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView tv_appname, tv_p_dog1, tv_p_dog2, tv_p_dog3, tv_p_dog4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_dog_list);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        img_p_dog1 = findViewById(R.id.img_p_dog1);
        img_p_dog2 = findViewById(R.id.img_p_dog2);
        img_p_dog3 = findViewById(R.id.img_p_dog3);
        img_p_dog4 = findViewById(R.id.img_p_dog4);
        tv_appname = findViewById(R.id.tv_appname);
        tv_p_dog1 = findViewById(R.id.tv_p_dog1);
        tv_p_dog2 = findViewById(R.id.tv_p_dog2);
        tv_p_dog3 = findViewById(R.id.tv_p_dog3);
        tv_p_dog4 = findViewById(R.id.tv_p_dog4);

    }
}