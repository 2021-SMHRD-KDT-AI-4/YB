package com.example.findyourdog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class F_Dog_Write_Result extends AppCompatActivity {


    private ImageButton imgbtn_f_s_info, imgbtn_f_s_tel,imgbtn_f_home;
    private ImageView img_f_dog_picture;
    private TextView tv_f_d_result_day,tv_f_d_result_place,tv_f_d_result_time,tv_f_d_result_tel,tv_f_d_result_kind;
    private StringRequest stringRequest;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_result);

        imgbtn_f_s_info = (ImageButton) findViewById(R.id.imgbtn_f_s_info);
        imgbtn_f_s_tel = (ImageButton) findViewById(R.id.imgbtn_f_s_tel);
        imgbtn_f_home = (ImageButton) findViewById(R.id.imgbtn_f_home);
        img_f_dog_picture = findViewById(R.id.img_f_dog_picture);
        tv_f_d_result_day = findViewById(R.id.tv_f_d_result_day);
        tv_f_d_result_place = findViewById(R.id.tv_f_d_result_place);
        tv_f_d_result_time = findViewById(R.id.tv_f_d_result_time);
        tv_f_d_result_tel = findViewById(R.id.tv_f_d_result_tel);
        tv_f_d_result_kind = findViewById(R.id.tv_f_d_result_kind);


        Intent intent = getIntent();
        F_Dog_DTO dto = (F_Dog_DTO) intent.getSerializableExtra("f_dog_dto");

        Log.v("f_dog_dto",dto.getDate().toString());
        byte[] imgbit = intent.getByteArrayExtra("imgbit");
        Bitmap bitmap = ArrayToBitmap(imgbit);
        if (dto != null) {
            tv_f_d_result_day.setText(dto.getDate().toString());
            tv_f_d_result_kind.setText(dto.getKind().toString());
            tv_f_d_result_place.setText(dto.getPlace().toString());
            tv_f_d_result_tel.setText(dto.getTel().toString());
            tv_f_d_result_time.setText(dto.getTime().toString());
            img_f_dog_picture.setImageBitmap(bitmap);
        }

        imgbtn_f_s_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calling(v);
            }
        });

        imgbtn_f_s_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        imgbtn_f_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(),Main.class);
                startActivity(home);
                finish();
            }
        });
    }
    void showDialog(){
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(F_Dog_Write_Result.this)
                .setTitle("보호소 위치")
                .setMessage("")
                .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }


    public void calling(View view){
        Log.v("callresult","gogo");
        Uri uri = Uri.parse("tel:010010101");
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
//        Intent intent = new Intent((Intent.ACTION_CALL));
//        intent.setData(Uri.parse("tel:01062159216"));
//        try {
//            startActivity(intent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_dog_nose_print_reg:
                new AlertDialog.Builder(this)
                        .setTitle("보호소 위치")
                        .setMessage("등록이 완료되었습니다!")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                break;
        }

    }
    public Bitmap ArrayToBitmap(byte[] byteArray) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        return bitmap;
    }



}
