package com.example.findyourdog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class F_Dog_Write_2 extends AppCompatActivity {

    private TextView tv_f_dog_info,tv_vital,tv_f_birth,tv_f_color,tv_f_type,tv_f_sex,tv_f_feature,
            tv_star1,tv_star2,tv_star3,tv_star4,tv_star5;
    private Button btn_f_next2;
    private EditText edt_f_birth, edt_f_color, edt_f_feature, edt_f_kg;
    private Spinner spn_f_breed, edt_f_sex;

    private StringRequest stringRequest;
    private RequestQueue queue;
    private StringRequest stringRequest2;
    private RequestQueue queue2;
    String result = "";
    private String f_filename = "";
    private String f_dog_json = "";


    String[] dogs = {"품종","골든 리트리버","닥스훈트","말티즈","믹스견","보더 콜리","비숑","시바",
            "시츄","요크셔 테리어","웰시 코기","진도견","차우차우","치와와","포메라니안","푸들","허스키","알수없음"};
    String[] gender = {"수컷","암컷","알수없음"};

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
        String f_day= intent.getStringExtra("f_Day");
        String f_time= intent.getStringExtra("f_time");
        String f_city= intent.getStringExtra("citynum");
        Log.v("f_city",f_city);
        String f_place= intent.getStringExtra("f_city");
        String f_tel= intent.getStringExtra("f_tel");
        f_filename= intent.getStringExtra("f_filename");
        String f_breed= intent.getStringExtra("f_breed");



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
//        genderspinner();
        Spinner genderspinner = findViewById(R.id.edt_f_sex);
        ArrayAdapter<String> genderadapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, gender
        );

        // 드롭다운 클릭 시 선택 창
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        genderspinner.setAdapter(genderadapter);
        // 스피너에서 선택 했을 경우 이벤트 처리

        btn_f_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f_feature = edt_f_feature.getText().toString();
                String f_sex = edt_f_sex.getSelectedItem().toString();
                String f_age = edt_f_birth.getText().toString();
                String f_color = edt_f_color.getText().toString();
                String f_kg = edt_f_kg.getText().toString();
                String f_s_breed = spn_f_breed.getSelectedItem().toString();

                F_Dog_DTO f_dog_dto = new F_Dog_DTO(f_id,f_type,f_day,f_time,f_city,f_place,f_tel,f_filename,
                        f_s_breed,f_feature,f_sex,f_age,f_color,f_kg);

                Gson gson = new Gson();
                f_dog_json = gson.toJson(f_dog_dto);
                Intent intent1 = new Intent(getApplicationContext(),F_Dog_Write_Result.class);
                byte[] imgbit = intent.getByteArrayExtra("bitarr");
                intent1.putExtra("f_dog_dto",f_dog_dto);
                intent1.putExtra("imgbit",imgbit);
                Log.v("result111",f_dog_json);


                sendRequest();


                Log.v("22233322",result);
                Log.v("222222","222222");


                Log.v("33333","3333333333");
                startActivity(intent1);

            }
        });

    }
//    private void genderspinner( ){
//        String[] gender_items = new String[]{
//                "수컷","암컷"
//        };
//        ArrayAdapter <String> genderAdapter = new ArrayAdapter<String>(
//                getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,gender_items);
//        genderAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        edt_f_sex.setAdapter(genderAdapter);
//        edt_f_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////                edt_info_sex.setText(gender_items[position]);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//    }


    public void sendRequest() {
        // Voolley Lib 새로운 요청객체 생성

        queue = Volley.newRequestQueue(this);
        String url = "http://211.63.240.26:8081/YB/F_Dog_Upload";

        RequestFuture<String> future = RequestFuture.newFuture();
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            //stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            // 응답데이터를 받아오는 곳


            @Override
            public void onResponse(String response) {
                Log.v("resultValue11", response);
                result = response;
                Log.v("resultValue123123", result);
                sendRequest2();


                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String board_num = jsonObject.getString("board_num");
                        String picture = jsonObject.getString("picture");

                        Log.v("board_num", board_num);
                        Log.v("picture", picture);
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

                params.put("dog_json",f_dog_json);
                params.put("testdata","test!");

                return params;
            }
        };
        queue.add(stringRequest);



    }
    public void sendRequest2() {
        // Voolley Lib 새로운 요청객체 생성
        Log.v("matchresult ::: ",result);
        queue2 = Volley.newRequestQueue(this);
        //String url = "http://59.0.147.251:5001/matchresult"; // 병주 주소
        String url = "http://211.63.240.26:5001/matchresult"; // 연지 주소

        stringRequest2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue22", response);
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

                Log.v("4444444","44444444");
                Log.v("matchresult",result); // 리스트
                String id = PreferenceManager.getString(getApplicationContext(),"id");
                params.put("id",id); // 아이디
                params.put("bitmap","f_dog_2");
                params.put("matchresult",result);
                params.put("f_filename",f_filename); // 파일네임

                return params;
            }
        };
        queue2.add(stringRequest2);
    }

}