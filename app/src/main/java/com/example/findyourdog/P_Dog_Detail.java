package com.example.findyourdog;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class P_Dog_Detail extends AppCompatActivity {

    private TextView p_d_sex,p_d_kind,p_d_color,p_d_kg,p_d_neutering,p_d_place,p_d_feature,p_d_birth,
                     tv_p_d_sex,tv_p_d_kind,tv_p_d_color,tv_p_d_kg,tv_p_d_neutering,tv_p_d_place,tv_p_d_feature,tv_p_d_birth,
                     shelter_place, adopt_ask;

    private ImageView img_p_d_dog;

    private ImageButton imgbtn_shelter_place, imgbtn_adopt_ask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_dog_detail);

        img_p_d_dog = findViewById(R.id.img_p_d_dog);

        tv_p_d_sex = findViewById(R.id.tv_p_d_sex);
        tv_p_d_birth = findViewById(R.id.tv_p_d_birth);
        tv_p_d_color = findViewById(R.id.tv_p_d_color);
        tv_p_d_kind = findViewById(R.id.tv_p_d_kind);
        tv_p_d_kg = findViewById(R.id.tv_p_d_kg);
        tv_p_d_place = findViewById(R.id.tv_p_d_place);
        tv_p_d_neutering = findViewById(R.id.tv_p_d_neutering);
        tv_p_d_feature = findViewById(R.id.tv_p_d_feature);




        Intent intent = getIntent();


        String picture = intent.getStringExtra("picture");
        setPic(picture,img_p_d_dog);
        String gender = intent.getStringExtra("gender");
        String age = intent.getStringExtra("age");
        String color = intent.getStringExtra("color");
        String kind = intent.getStringExtra("kind");
        String weight = intent.getStringExtra("weight");
        String shelter = intent.getStringExtra("shelter");
        String neuter = intent.getStringExtra("neuter");
        String content = intent.getStringExtra("content");
        String addr = intent.getStringExtra("addr");
        String tel = intent.getStringExtra("tel");


        tv_p_d_sex.setText(gender);
        tv_p_d_birth.setText(age+" (연도)");
        tv_p_d_color.setText(color);
        tv_p_d_kind.setText(kind);
        tv_p_d_kg.setText(weight+" (kg)");
        tv_p_d_place.setText(shelter);
        tv_p_d_neutering.setText(neuter);
        tv_p_d_feature.setText(content);

        imgbtn_shelter_place = findViewById(R.id.imgbtn_shelter_place);

        imgbtn_shelter_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v, addr);
            }
        });

        imgbtn_adopt_ask = findViewById(R.id.imgbtn_adopt_ask);

        imgbtn_adopt_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calling(v, tel);
            }
        });

    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder="+"AdpPic"+"&filename="+filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }

    void showDialog(View v, String addr){
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(P_Dog_Detail.this)

                .setTitle("보호소 위치")
                .setMessage(addr)
                .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();

    }

    public void calling(View view, String tel){
        Uri uri = Uri.parse("tel:"+tel);
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
    }



}
