package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import java.util.Arrays;

public class F_Dog_Write_2 extends AppCompatActivity {

    private TextView tv_f_dog_info,tv_vital,tv_f_birth,tv_f_color,tv_f_type,tv_f_sex,tv_f_feature,
            tv_star1,tv_star2,tv_star3,tv_star4,tv_star5;
    private Button btn_f_next2;
    private EditText edt_f_birth, edt_f_color, edt_f_sex, edt_f_feature, edt_f_kg;
    private Spinner spn_f_breed;

    private StringRequest stringRequest;
    private RequestQueue queue;

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
        String f_breed= intent.getStringExtra("f_breed");
        String f_day= intent.getStringExtra("f_day");
        String f_tel= intent.getStringExtra("f_tel");
        String f_city= intent.getStringExtra("f_city");
        String f_place= intent.getStringExtra("f_place");
        String f_time= intent.getStringExtra("f_time");

        String f_age = edt_f_birth.getText().toString();
        String f_color = edt_f_color.getText().toString();
        String f_feature = edt_f_feature.getText().toString();
        String f_sex = edt_f_sex.getText().toString();
        String f_kg = edt_f_kg.getText().toString();

        String[] f_dog_info = {f_day,f_tel,f_city,f_place,f_time,f_age,f_color,f_feature,f_sex,f_kg};

        btn_f_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),F_Dog_Write_Result.class);
                intent1.putExtra("f_breed",f_breed);
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
            int dogs_index = Arrays.binarySearch(dogs, f_breed);
            spinner.setSelection(dogs_index);
        }

    }

//    public void sendRequest() {
//        // Voolley Lib 새로운 요청객체 생성
//        queue = Volley.newRequestQueue(this);
//        String url = "http://211.63.240.26:8081/YB/BoardService";
//
//        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            // 응답데이터를 받아오는 곳
//            @Override
//            public void onResponse(String response) {
//                Log.v("resultValue", response);
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//
//                    String dogBreed = jsonObject.getString("dog_breed");
//                    Log.v("dogbreed",dogBreed);
//                    if (dogBreed != null) {
//
//                        Intent intent = new Intent(getApplicationContext(), F_Dog_Write_2.class);
//                        String e_f_Day = edt_f_day.getText().toString();
//                        String e_f_tel = edt_f_tel.getText().toString();
//                        String f_city = spn_f_sido.getSelectedItem().toString() ;
//                        String e_f_place = edt_f_place.getText().toString();
//                        String e_f_time = edt_f_time.getText().toString();
//
//                        intent.putExtra("f_Day",e_f_Day);
//                        intent.putExtra("f_tel",e_f_tel);
//                        intent.putExtra("f_city",f_city);
//                        intent.putExtra("f_place",e_f_place);
//                        intent.putExtra("f_time",e_f_time);
//                        intent.putExtra("f_breed",dogBreed);
//
//                        startActivity(intent);
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            // 서버와의 연동 에러시 출력
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        }) {
//            @Override //response를 UTF8로 변경해주는 소스코드
//            protected Response<String> parseNetworkResponse(NetworkResponse response) {
//                try {
//                    String utf8String = new String(response.data, "UTF-8");
//                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
//                } catch (UnsupportedEncodingException e) {
//                    // log error
//                    return Response.error(new ParseError(e));
//                } catch (Exception e) {
//                    // log error
//                    return Response.error(new ParseError(e));
//                }
//            }
//
//            // 보낼 데이터를 저장하는 곳
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//
//
//                return params;
//            }
//        };
//        queue.add(stringRequest);
//    }

}