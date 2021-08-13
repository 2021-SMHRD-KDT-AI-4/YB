package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Detail extends AppCompatActivity {

    private ImageView img_l_d_dog;
    private TextView tv_l_d_sex,tv_l_d_age,tv_l_d_color,tv_l_d_kind,tv_l_d_kg,tv_l_d_day,tv_l_d_place,tv_l_d_time,tv_l_d_tel,tv_l_d_etc;
    private Button btn_comment_go;
    private ImageButton imgbtn_l_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_detail);


        tv_l_d_sex = findViewById(R.id.tv_l_d_sex);
        tv_l_d_age = findViewById(R.id.tv_l_d_age);
        tv_l_d_color = findViewById(R.id.tv_l_d_color);
        tv_l_d_kind = findViewById(R.id.tv_l_d_kind);
        tv_l_d_kg = findViewById(R.id.tv_l_d_kg);
        tv_l_d_day = findViewById(R.id.tv_l_d_day);
        tv_l_d_place = findViewById(R.id.tv_l_d_place);
        tv_l_d_time = findViewById(R.id.tv_l_d_time);
        tv_l_d_tel = findViewById(R.id.tv_l_d_tel);
        tv_l_d_etc = findViewById(R.id.tv_l_d_etc);
        img_l_d_dog = findViewById(R.id.img_l_d_dog);
        imgbtn_l_back = findViewById(R.id.imgbtn_l_back);
        imgbtn_l_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main.class);
                finish();
                startActivity(intent);
            }
        });

        btn_comment_go = findViewById(R.id.btn_comment_go);


        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String gender = intent.getStringExtra("gender");
        String picture = intent.getStringExtra("picture");
        setPic(picture,img_l_d_dog);

        String age = intent.getStringExtra("age");
        String color = intent.getStringExtra("color");
        String kind = intent.getStringExtra("kind");
        String weight = intent.getStringExtra("weight");
        String missing_date = intent.getStringExtra("missing_date");
        String missing_time = intent.getStringExtra("missing_time");
        String place = intent.getStringExtra("place");
        String tel = intent.getStringExtra("tel");
        String content = intent.getStringExtra("content");
        String board_num = intent.getStringExtra("board_num");


        btn_comment_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Comments.class);
                intent.putExtra("board_num",board_num);
                startActivity(intent);

            }
        });

        tv_l_d_sex.setText(gender);
        tv_l_d_age.setText(age+"(연도)");
        tv_l_d_color.setText(color);
        tv_l_d_kind.setText(kind);
        tv_l_d_kg.setText(weight+" (kg)");
        tv_l_d_day.setText(missing_date);
        tv_l_d_time.setText(missing_time);
        tv_l_d_place.setText(place);
        tv_l_d_tel.setText(tel);
        tv_l_d_etc.setText(content);


    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder="+"BoardPic"+"&filename="+filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }
}