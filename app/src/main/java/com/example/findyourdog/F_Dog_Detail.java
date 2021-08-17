package com.example.findyourdog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class F_Dog_Detail extends AppCompatActivity {

    private ImageView img_f_d_dog;
    private TextView f_d_day, f_d_place, f_d_time,
            tv_f_d_sex,tv_f_d_age,tv_f_d_color,tv_f_d_kind,tv_f_d_weight, tv_f_d_day,tv_f_d_place,
            tv_f_d_time,tv_f_d_tel,tv_f_d_etc;
    private EditText edt_write_review;
    private Button btn_comment_go;
    private StringRequest stringRequest;
    private RequestQueue queue;
    private String result;
    private ImageButton imgbtn_f_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_detail);

        f_d_day = findViewById(R.id.f_d_day);
        f_d_place = findViewById(R.id.f_d_place);
        f_d_time = findViewById(R.id.f_d_time);

        tv_f_d_sex = findViewById(R.id.tv_f_d_sex);
        tv_f_d_age = findViewById(R.id.tv_f_d_age);
        tv_f_d_color = findViewById(R.id.tv_f_d_color);
        tv_f_d_kind = findViewById(R.id.tv_f_d_kind);
        tv_f_d_weight = findViewById(R.id.tv_f_d_weight);
        tv_f_d_day = findViewById(R.id.tv_f_d_day);
        tv_f_d_place = findViewById(R.id.tv_f_d_place);
        tv_f_d_time = findViewById(R.id.tv_f_d_time);
        tv_f_d_time.setSelected(true);
        tv_f_d_tel = findViewById(R.id.tv_f_d_tel);
        tv_f_d_etc = findViewById(R.id.tv_f_d_etc);
        img_f_d_dog = findViewById(R.id.img_f_d_dog);
        imgbtn_f_back = findViewById(R.id.imgbtn_f_back);
        imgbtn_f_back.setOnClickListener(new View.OnClickListener() {
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
        setPic(picture,img_f_d_dog);


        String age = intent.getStringExtra("age");
        String color = intent.getStringExtra("color");
        String kind = intent.getStringExtra("kind");
        String weight = intent.getStringExtra("weight");
        String missing_date = intent.getStringExtra("missing_date");
        String missing_time = intent.getStringExtra("missing_time");
        String notice = intent.getStringExtra("notice");
        String shelter = intent.getStringExtra("shelter");
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


        tv_f_d_sex.setText(gender);
        tv_f_d_age.setText(age+"(연도)");
        tv_f_d_color.setText(color);
        tv_f_d_kind.setText(kind);
        tv_f_d_weight.setText(weight+" (kg)");
        tv_f_d_place.setText(shelter);
        tv_f_d_tel.setText(tel);
        tv_f_d_etc.setText(content);

        if(id.equals("root")){

            tv_f_d_day.setText(notice);
            tv_f_d_time.setText(place);

            f_d_day.setText("공고기간");
            f_d_place.setText("관할보호센터");
            f_d_time.setText("보호장소");

        } else {
//            if(place == null){
//                f_d_place.setVisibility(View.INVISIBLE);
//            }
//            f_d_day.setVisibility(View.GONE);
            f_d_day.setText("목격날짜");
            f_d_place.setText("목격위치");
            tv_f_d_place.setText(place);
            f_d_time.setText("목격시간");
            tv_f_d_day.setText(missing_date);
            tv_f_d_time.setText(missing_time);
        }

    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder="+"BoardPic"+"&filename="+filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }




}