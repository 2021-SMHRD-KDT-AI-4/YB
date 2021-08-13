package com.example.findyourdog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

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
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class L_Dog_Write2 extends AppCompatActivity {

    private EditText edt_l_sex, edt_l_birth, edt_l_color, edt_l_type, edt_l_kg, edt_l_feature;
    private Button btn_l_picture_plus,btn_l_enroll;
    private ImageView img_l_dog_picture;
    private Spinner spn_type;
    private StringRequest stringRequest;
    private RequestQueue queue;


    Random r = new Random();
    byte[] bitarr;
    String id = "";
    int rand = 0;
    String matchresult="";
    String f_filename="";
    String l_dog_json = "";
    ArrayList<F_Dog_DTO> pictures = new ArrayList<F_Dog_DTO>();
    F_Dog_DTO f_dto;
    String[] dogs = {"품종","골든 리트리버","닥스훈트","말티즈","믹스견","보더 콜리","비숑","시바",
            "시츄","요크셔 테리어","웰시 코기","진도견","차우차우","치와와","포메라니안","푸들","허스키","알수없음"};

    String l_day = "";
    String l_type = "";
    String l_place = "";
    String l_time = "";
    String l_tel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write2);
        Log.v("L_Write2","O");

        edt_l_sex = findViewById(R.id.edt_l_sex);
        edt_l_birth = findViewById(R.id.edt_l_birth);
        edt_l_color = findViewById(R.id.edt_l_color);
        spn_type =findViewById(R.id.spn_l_type);
        edt_l_kg = findViewById(R.id.edt_l_kg);
        edt_l_feature = findViewById(R.id.edt_l_feature);
        btn_l_enroll = findViewById(R.id.btn_l_enroll);
        btn_l_picture_plus = findViewById(R.id.btn_l_picture_plus);
        img_l_dog_picture = findViewById(R.id.img_l_dog_picture2);


        Intent intent3 = getIntent();
        l_day = intent3.getStringExtra("l_day");
        l_place = intent3.getStringExtra("l_place");
        l_time = intent3.getStringExtra("l_time");
        l_tel = intent3.getStringExtra("l_tel");
        String l_city = intent3.getStringExtra("l_city");

        Spinner spinner = findViewById(R.id.spn_l_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, dogs
        );

        // 드롭다운 클릭 시 선택 창
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);
        // 스피너에서 선택 했을 경우 이벤트 처리

        btn_l_picture_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 500);

            }
        });

        btn_l_enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String l_sex = edt_l_sex.getText().toString();
                String l_age = edt_l_birth.getText().toString();
                String l_color = edt_l_color.getText().toString();
                String l_kind = spinner.getSelectedItem().toString();
                String l_kg = edt_l_kg.getText().toString();
                String l_feature = edt_l_feature.getText().toString();
                id = PreferenceManager.getString(getApplicationContext(),"id");

                rand = r.nextInt(1000);
                f_filename = id+rand+".jpg";
                l_type = "1";

                F_Dog_DTO l_dog_dto = new F_Dog_DTO(id,l_type,l_day,l_time,l_city,l_place,l_tel,f_filename,
                        l_kind,l_feature,l_sex,l_age,l_color,l_kg);
                Gson gson = new Gson();
                l_dog_json = gson.toJson(l_dog_dto);
                Log.v("test1","test1");
                sendRequest();
                Log.v("test111",matchresult);
//                sendRequest2();
                Log.v("test2","test2");



            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 500 && resultCode == RESULT_OK){
            try {
                InputStream in = getContentResolver().openInputStream(data.getData());
                Bitmap img = BitmapFactory.decodeStream(in);
                bitarr = BitmaptoArray(img);
                img_l_dog_picture.setImageBitmap(img);
                in.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(resultCode == RESULT_CANCELED){
            Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
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
                Log.v("test4", response);
                matchresult = response;

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String board_num = jsonObject.getString("board_num");
                        String picture = jsonObject.getString("picture");
                        Log.v("board_num", board_num);
                        Log.v("picture", picture);

                    }
                    Intent intent1 = new Intent(getApplicationContext(),L_Dog_Write_Result.class);
                    intent1.putExtra("l_type",l_type);
                    intent1.putExtra("l_day",l_day);
                    intent1.putExtra("l_place",l_place);
                    intent1.putExtra("l_time",l_time);
                    intent1.putExtra("l_tel",l_tel);
                    intent1.putExtra("bitarr",bitarr);
                    intent1.putExtra("matchresult",matchresult);
                    intent1.putExtra("f_filename",f_filename);
                    startActivity(intent1);

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

                params.put("dog_json",l_dog_json);
                params.put("testdata","test!");
                Log.v("test3","test3");
                return params;
            }
        };
        queue.add(stringRequest);

    }

    // Bitmap -> Base64 변환
    public String BitmapToBase64(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bImage = baos.toByteArray();
        String base64 = Base64.encodeToString(bImage, Base64.DEFAULT);
        return base64;
    }
    //  bitmap -> array
    public byte[] BitmaptoArray(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bImage = baos.toByteArray();
        return bImage;
        }


}