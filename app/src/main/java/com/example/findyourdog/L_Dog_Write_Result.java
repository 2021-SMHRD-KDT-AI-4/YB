package com.example.findyourdog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
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

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class L_Dog_Write_Result extends AppCompatActivity {

    private TextView tv_l_day,tv_l_place,tv_l_time,tv_l_tel,l_dog_kind;
    private ImageView l_dog_picture2;
    private ImageButton imgbtn_l_s_tel, imgbtn_l_s_info,imgbtn_l_home;

    String matchresult="";
    String f_filename = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write_result);

        l_dog_kind = findViewById(R.id.tv_l_d_result_kind);
        l_dog_picture2 = findViewById(R.id.img_l_dog_picture2);
        imgbtn_l_s_tel =(ImageButton) findViewById(R.id.imgbtn_l_s_tel);
        imgbtn_l_s_info =(ImageButton) findViewById(R.id.imgbtn_l_s_info);
        imgbtn_l_home = (ImageButton) findViewById(R.id.imgbtn_l_home);

        tv_l_day =findViewById(R.id.tv_l_d_result_day);
        tv_l_place =findViewById(R.id.tv_l_d_result_place);
        tv_l_time =findViewById(R.id.tv_l_d_result_time);
        tv_l_tel =findViewById(R.id.tv_l_d_result_tel);

        Intent intent = getIntent();
        l_dog_kind.setText(intent.getStringExtra("l_kind"));
        tv_l_day.setText(intent.getStringExtra("l_day"));
        String city = intent.getStringExtra("l_city");
        String place = intent.getStringExtra("l_place");
        tv_l_place.setText(place);
        tv_l_time.setText(intent.getStringExtra("l_time"));
        tv_l_tel.setText(intent.getStringExtra("l_tel"));
        byte[] bitarr =intent.getByteArrayExtra("bitarr");
        f_filename = intent.getStringExtra("f_filename");
        matchresult = intent.getStringExtra("matchresult");
        Log.v("123123123",matchresult);
        Bitmap bitmap = ArrayToBitmap(bitarr);
        l_dog_picture2.setImageBitmap(bitmap);

        imgbtn_l_s_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calling(v);
//                Intent intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse("tel:01012341234"));
//                try {
//                    startActivity(intent);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

            }
        });

        imgbtn_l_s_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        imgbtn_l_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(),Main.class);

                startActivity(home);
                finish();
            }
        });
    }
    void showDialog(){
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(L_Dog_Write_Result.this)

                .setTitle("광주 동물보호소")
                .setMessage("광주광역시 북구 본촌마을길 25 (본촌동, 건국동사무소)")
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
        Uri uri = Uri.parse("tel:0625712808");
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