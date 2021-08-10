package com.example.findyourdog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private Button btn_write_review;
    private StringRequest stringRequest;
    private RequestQueue queue;
    private String result;


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
        edt_write_review = findViewById(R.id.edt_write_review);
        btn_write_review = findViewById(R.id.btn_write_review);

        btn_write_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

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
            tv_f_d_day.setText(missing_date);
            tv_f_d_time.setText(missing_time);
        }

    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder="+"BoardPic"+"&filename="+filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }
    public void sendRequest(){
        // Voolley Lib 새료운 요청객체 생성
        queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://211.63.240.26:8081/YB/CommentWriteService";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    result = jsonObject.getString("ischeck");
                    if (result.equals("true")){
                        Log.v("resultValue",result);
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setTitle("댓글등록").setMessage("댓글등록이 완료되었습니다.");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(),Main.class);
                                startActivity(intent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setTitle("댓글등록").setMessage("댓글등록이 실패되었습니다.");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(),Main.class);
                                startActivity(intent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
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
                 String id = PreferenceManager.getString(getApplicationContext(),"id");


                params.put("edt_write_review", edt_write_review.getText().toString());
                String board_num = getIntent().getStringExtra("board_num");

                params.put("board_num", board_num);
                params.put("id", id);

                Log.v("review",board_num);
                Log.v("review",edt_write_review.getText().toString());
                Log.v("id",id);



                return params;
            }
        };


        queue.add(stringRequest);
    }


}