package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class F_Dog_Write_2 extends AppCompatActivity {

    private TextView tv_f_dog_info,tv_vital,tv_f_birth,tv_f_color,tv_f_type,tv_f_sex,tv_f_feature,
            tv_star1,tv_star2,tv_star3,tv_star4,tv_star5;
    private Button btn_f_next2;
    private EditText edt_f_birth, edt_f_color, edt_f_sex, edt_f_feature, edt_f_kg;
    private Spinner spn_f_breed;

    private StringRequest stringRequest;
    private RequestQueue queue;

    String f_dog_json = "";
    String[] dogs = {"품종","골든리트리버","닥스훈트","말티즈","믹스견","보더콜리","비숑","시바견",
            "시츄","요크셔테리어","웰시코기","진돗개","차우차우","치와와","포메라니안","미니어처푸들","허스키","알수없음"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_2);

        spn_f_breed = findViewById(R.id.spn_f_breed);
        edt_f_birth = findViewById(R.id.edt_f_birth);
        edt_f_color = findViewById(R.id.edt_f_color);
        edt_f_feature = findViewById(R.id.edt_f_feature);
        edt_f_sex = findViewById(R.id.edt_f_sex);
        edt_f_kg = findViewById(R.id.edt_f_kg);
        btn_f_next2 = findViewById(R.id.btn_f_next2);

        Intent intent = getIntent();
        String f_id = intent.getStringExtra("f_id");
        String f_type = intent.getStringExtra("f_type");
        String f_day= intent.getStringExtra("f_day");
        String f_time= intent.getStringExtra("f_time");
        String f_city= intent.getStringExtra("f_city");
        Log.v("f_city",f_city);
        String f_place= intent.getStringExtra("f_place");
        String f_tel= intent.getStringExtra("f_tel");
        String f_filename= intent.getStringExtra("f_filename");
        String f_breed= intent.getStringExtra("f_breed");


        btn_f_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f_feature = edt_f_feature.getText().toString();
                String f_sex = edt_f_sex.getText().toString();
                String f_age = edt_f_birth.getText().toString();
                String f_color = edt_f_color.getText().toString();
                String f_kg = edt_f_kg.getText().toString();
                String f_s_breed = spn_f_breed.getSelectedItem().toString();

                F_Dog_DTO f_dog_dto = new F_Dog_DTO(f_id,f_type,f_day,f_time,f_city,f_place,f_tel,f_filename,
                        f_s_breed,f_feature,f_sex,f_age,f_color,f_kg);

                Gson gson = new Gson();
                f_dog_json = gson.toJson(f_dog_dto);
                Intent intent1 = new Intent(getApplicationContext(),F_Dog_Write_Result.class);

                intent1.putExtra("f_dog_dto",f_dog_dto);
                sendRequest();
                startActivity(intent1);


            }
        });


        Spinner spinner = findViewById(R.id.spn_f_breed);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, dogs
        );

        // 드롭다운 클릭 시 선택 창
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);
        // 스피너에서 선택 했을 경우 이벤트 처리

        if (f_breed != null) {

            int dogs_index = Arrays.asList(dogs).indexOf(f_breed);
            spinner.setSelection(dogs_index);
        }

    }

    public void sendRequest() {
        // Voolley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.147.251:8082/YB/F_Dog_Upload"; // 병주 주소

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String result = jsonObject.getString("reulstest");
                    Log.v("resultest",result);


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
                String testdata = "test!";
                params.put("f_dog_json",f_dog_json);
                params.put("testdata",testdata);

                return params;
            }
        };
        queue.add(stringRequest);
    }

}