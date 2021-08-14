package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_print_Search_list_Success_Shelter extends AppCompatActivity {

    private ImageView img_success_shelter;
    private TextView tv_find_shelter;
    private TextView tv_owner_tel, tv_owner_name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_search_list_success_shelter);

        Intent intent = getIntent();

        String dog_name = intent.getStringExtra("dog_name");
        String name = intent.getStringExtra("name");
        String info = intent.getStringExtra("info");
        String picture = intent.getStringExtra("picture");

        img_success_shelter = findViewById(R.id.img_success_shelter);
        tv_find_shelter = findViewById(R.id.tv_find_shelter);
        tv_owner_tel = findViewById(R.id.tv_owner_tel);
        tv_owner_name1 = findViewById(R.id.tv_owner_name1);

        setPic(picture, img_success_shelter);
        tv_find_shelter.setText("'"+dog_name+"'를 찾았어요!");
        tv_owner_name1.setText(name);
        tv_owner_tel.setText("0"+info);

    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder="+"Nose_Print"+"&filename="+filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }
}