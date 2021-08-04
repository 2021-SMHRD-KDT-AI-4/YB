package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class F_Dog_Write_Result extends AppCompatActivity {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_f_dog_s, btn_f_dog_s_call;
    private ImageView img_menu, img_f_dog;
    private TextView tv_appname, tv_f_dog_ok, tv_f_dog, tv_f_dog_s, tv_f_dog_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_result);

        img_menu = findViewById(R.id.img_menu);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_f_dog_s = findViewById(R.id.btn_f_dog_s);
        btn_f_dog_s_call = findViewById(R.id.btn_f_dog_s_call);
        img_f_dog = findViewById(R.id.img_f_dog);
        tv_appname = findViewById(R.id.tv_appname);
        tv_f_dog_ok = findViewById(R.id.tv_f_dog_ok);
        tv_f_dog = findViewById(R.id.tv_f_dog);
        tv_f_dog_s = findViewById(R.id.tv_f_dog_s);
        tv_f_dog_info = findViewById(R.id.tv_f_dog_info);
    }
}