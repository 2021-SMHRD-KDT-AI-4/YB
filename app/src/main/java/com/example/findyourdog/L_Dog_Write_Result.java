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

    private TextView tv_l_type,tv_l_day,tv_l_place,tv_l_time,tv_l_tel;
    private ImageView l_dog_picture2;
    private ImageButton imgbtn_l_s_tel, imgbtn_l_s_info,imgbtn_l_home;

    private StringRequest stringRequest;
    private RequestQueue queue;
    String matchresult="";
    String f_filename = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write_result);


        l_dog_picture2 = findViewById(R.id.img_l_dog_picture2);
        imgbtn_l_s_tel =(ImageButton) findViewById(R.id.imgbtn_l_s_tel);
        imgbtn_l_s_info =(ImageButton) findViewById(R.id.imgbtn_l_s_info);
        imgbtn_l_home = (ImageButton) findViewById(R.id.imgbtn_l_home);
        tv_l_type =findViewById(R.id.tv_l_d_result_kind2);
        tv_l_day =findViewById(R.id.tv_l_d_result_day);
        tv_l_place =findViewById(R.id.tv_l_d_result_place);
        tv_l_time =findViewById(R.id.tv_l_d_result_time);
        tv_l_tel =findViewById(R.id.tv_l_d_result_tel);

        Intent intent = getIntent();
        tv_l_type.setText(intent.getStringExtra("l_type"));
        tv_l_day.setText(intent.getStringExtra("l_day"));
        tv_l_place.setText(intent.getStringExtra("l_place"));
        tv_l_time.setText(intent.getStringExtra("l_time"));
        tv_l_tel.setText(intent.getStringExtra("l_tel"));
        byte[] bitarr =intent.getByteArrayExtra("bitarr");
        f_filename = intent.getStringExtra("f_filename");
        matchresult = intent.getStringExtra("matchresult");
        Log.v("123123123",matchresult);
        Bitmap bitmap = ArrayToBitmap(bitarr);
        l_dog_picture2.setImageBitmap(bitmap);

        sendRequest2();

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
    public void sendRequest2() {
        // Voolley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.147.251:5001/matchresult"; // 병주 주소

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue2", response);

//                try {
//                    JSONArray jsonArray = new JSONArray(response);
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
            }
        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override //response를 UTF8로 변경해주는 소스코드
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }

            // 보낼 데이터를 저장하는 곳
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("matchresult",matchresult);
                params.put("f_filename",f_filename);


                return params;
            }
        };
        queue.add(stringRequest);
    }

}