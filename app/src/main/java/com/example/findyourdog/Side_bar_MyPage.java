package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Side_bar_MyPage extends AppCompatActivity {

    private ImageView img_menu;
    private TextView app_name, tv_mypage, tv_mypage_dog_nose;
    private TextView tv_mypage_dog_name, tv_mypage_ok;
    private Button btn_mypage_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar_my_page);

        img_menu = findViewById(R.id.img_menu);
        app_name = findViewById(R.id.app_name);
        tv_mypage = findViewById(R.id.tv_mypage);
        tv_mypage_dog_nose = findViewById(R.id.tv_mypage_dog_nose);
        tv_mypage_dog_name = findViewById(R.id.tv_mypage_dog_name);
        tv_mypage_ok = findViewById(R.id.tv_mypage_ok);
        btn_mypage_plus = findViewById(R.id.btn_mypage_plus);
    }
}