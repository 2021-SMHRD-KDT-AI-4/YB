package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        btn_find = findViewById(R.id.btn_find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Picture_Search_Result.class);
                startActivity(intent);
            }
        });
    }
}