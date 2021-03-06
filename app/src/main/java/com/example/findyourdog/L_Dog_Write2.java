package com.example.findyourdog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

    private EditText  edt_l_birth, edt_l_color, edt_l_type, edt_l_kg, edt_l_feature;
    private Button btn_l_picture_plus,btn_l_enroll;
    private ImageView img_l_dog_picture;
    private Spinner spn_type,edt_l_sex;
    private StringRequest stringRequest;
    private RequestQueue queue;
    private StringRequest stringRequest2;
    private RequestQueue queue2;


    Random r = new Random();
    byte[] bitarr;
    String id = "";
    int rand = 0;
    String matchresult="";
    String f_filename="";
    String l_dog_json = "";
    ArrayList<F_Dog_DTO> pictures = new ArrayList<F_Dog_DTO>();
    F_Dog_DTO f_dto;
    String[] dogs = {"??????","?????? ????????????","????????????","?????????","?????????","?????? ??????","??????","??????",
            "??????","????????? ?????????","?????? ??????","?????????","????????????","?????????","???????????????","??????","?????????","????????????"};
    String[] gender = {"??????","??????","????????????"};

    String l_day = "";
    String l_type = "";
    String l_place = "";
    String l_time = "";
    String l_tel = "";
    String l_kind = "";
    String l_city = "";


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
        String l_citynum = intent3.getStringExtra("cityNum");
        l_city = intent3.getStringExtra("l_city");
//        genderspinner();
        Spinner genderspinner = findViewById(R.id.edt_l_sex);
        ArrayAdapter<String> genderadapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, gender
        );

        // ???????????? ?????? ??? ?????? ???
        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // ???????????? ????????? ??????
        genderspinner.setAdapter(genderadapter);
        // ??????????????? ?????? ?????? ?????? ????????? ??????

        Spinner spinner = findViewById(R.id.spn_l_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, dogs
        );

        // ???????????? ?????? ??? ?????? ???
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // ???????????? ????????? ??????
        spinner.setAdapter(adapter);
        // ??????????????? ?????? ?????? ?????? ????????? ??????

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


                String l_sex = edt_l_sex.getSelectedItem().toString();
                String l_age = edt_l_birth.getText().toString();
                String l_color = edt_l_color.getText().toString();
                l_kind = spinner.getSelectedItem().toString();
                String l_kg = edt_l_kg.getText().toString();
                String l_feature = edt_l_feature.getText().toString();
                id = PreferenceManager.getString(getApplicationContext(),"id");
                l_place = l_city+" "+l_place;
                rand = r.nextInt(1000);
                f_filename = id+"_"+rand+".jpg";
                l_type = "1";

                F_Dog_DTO l_dog_dto = new F_Dog_DTO(id,l_type,l_day,l_time,l_citynum,l_place,l_tel,f_filename,
                        l_kind,l_feature,l_sex,l_age,l_color,l_kg);
                Gson gson = new Gson();
                l_dog_json = gson.toJson(l_dog_dto);
                Log.v("test1","test1");

                sendRequest();

                Log.v("test2","test2");

            }
        });


    }
//    private void genderspinner( ){
//        String[] gender_items = new String[]{
//                "??????","??????"
//        };
//        ArrayAdapter <String> genderAdapter = new ArrayAdapter<String>(
//                getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,gender_items);
//        genderAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        edt_l_sex.setAdapter(genderAdapter);
//        edt_l_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
            Toast.makeText(this, "?????? ?????? ??????", Toast.LENGTH_LONG).show();
        }
    }

    public void sendRequest() {
        // Voolley Lib ????????? ???????????? ??????
        queue = Volley.newRequestQueue(this);
        String url = "http://211.63.240.26:8081/YB/F_Dog_Upload";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {
                Log.v("test4", response);
                matchresult = response;
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
                    Intent intent1 = new Intent(getApplicationContext(),L_Dog_Write_Result.class);
                    intent1.putExtra("l_kind",l_kind);
                    intent1.putExtra("l_day",l_day);
                    intent1.putExtra("l_city",l_city);
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
            // ???????????? ?????? ????????? ??????
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override //response??? UTF8??? ??????????????? ????????????
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

            // ?????? ???????????? ???????????? ???
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
    public void sendRequest2() {
        // Voolley Lib ????????? ???????????? ??????
        queue2 = Volley.newRequestQueue(this);
        String url = "http://211.63.240.26:5001/matchresult"; // ?????? ??????
        //String url = "http://59.0.147.251:5001/matchresult"; // ?????? ??????

        stringRequest2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {
                Log.v("resultValue2", response);
            }
        }, new Response.ErrorListener() {
            // ???????????? ?????? ????????? ??????
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override //response??? UTF8??? ??????????????? ????????????
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

            // ?????? ???????????? ???????????? ???
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                String id = PreferenceManager.getString(getApplicationContext(),"id");
                params.put("id",id);

                BitmapDrawable drawable = (BitmapDrawable) img_l_dog_picture.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String imgStr = BitmapToBase64(bitmap);

                params.put("bitmap",imgStr);
                params.put("matchresult",matchresult);
                params.put("f_filename",f_filename);


                return params;
            }
        };
        queue2.add(stringRequest2);
    }
    // Bitmap -> Base64 ??????
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