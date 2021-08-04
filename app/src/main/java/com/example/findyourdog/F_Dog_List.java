package com.example.findyourdog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class F_Dog_List extends AppCompatActivity {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_write;
    private TextView app_name2, main_type1, main_type2, main_type3, main_type4;
    private ImageView main_img1, main_img2, main_img3, main_img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_list);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_write = findViewById(R.id.btn_write);
        app_name2 = findViewById(R.id.app_name2);
        main_type1 = findViewById(R.id.main_type1);
        main_type2 = findViewById(R.id.main_type2);
        main_type3 = findViewById(R.id.main_type3);
        main_type4 = findViewById(R.id.main_type4);
        main_img1 = findViewById(R.id.main_img1);
        main_img2 = findViewById(R.id.main_img2);
        main_img3 = findViewById(R.id.main_img3);
        main_img4 = findViewById(R.id.main_img4);

    }
}