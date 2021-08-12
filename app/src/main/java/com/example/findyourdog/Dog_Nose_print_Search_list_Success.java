package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_print_Search_list_Success extends AppCompatActivity {

    private ImageView img_success;
    private TextView tv_find;
    private TextView tv_shelter_name2, tv_shelter_add2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_search_list_success);

        Intent intent = getIntent();

        String dog_name = intent.getStringExtra("dog_name");
        String name = intent.getStringExtra("name");
        String info = intent.getStringExtra("info");
        String picture = intent.getStringExtra("picture");


        img_success = findViewById(R.id.img_success);
        tv_find = findViewById(R.id.tv_find);
        tv_shelter_name2 = findViewById(R.id.tv_shelter_name2);
        tv_shelter_add2 = findViewById(R.id.tv_shelter_add2);

        setPic(picture,img_success);
        tv_find.setText("'"+dog_name+"'를 찾았어요!");
        tv_shelter_name2.setText(name);
        tv_shelter_add2.setText(info);


    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder="+"Nose_Print"+"&filename="+filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }

}