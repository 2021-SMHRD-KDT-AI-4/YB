package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Write_Result extends AppCompatActivity {

    private ImageView img_menu, img_l_dog;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_l_dog_s, btn_l_dog_s_call;
    private TextView tv_appname, tv_l_dog_ok, tv_l_dog, tv_l_dog_detail, tv_l_dog_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write_result);

        img_menu = findViewById(R.id.img_menu);
        img_l_dog = findViewById(R.id.img_f_dog);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_l_dog_s = findViewById(R.id.btn_l_dog_s);
        btn_l_dog_s_call = findViewById(R.id.btn_l_dog_s_call);
        tv_appname = findViewById(R.id.tv_appname);
        tv_l_dog_ok = findViewById(R.id.tv_l_dog_ok);
        tv_l_dog = findViewById(R.id.tv_l_dog);
        tv_l_dog_detail = findViewById(R.id.tv_l_dog_detail);
        tv_l_dog_s = findViewById(R.id.tv_l_dog_s);



    }
}