package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Join extends AppCompatActivity {

    private ImageView img_menu;
    private TextView tv_id_check;
    private EditText edt_join_id, edt_join_pw, edt_join_name, edt_join_tel, edt_join_addr;
    private Button  btn_join, btn_id_check;
    private CheckBox shelter_check;

    private RequestQueue queue;
    private StringRequest stringRequest;
    private String idcheck;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        tv_id_check = findViewById(R.id.tv_id_check);
        edt_join_id = findViewById(R.id.edt_join_id);
        edt_join_pw = findViewById(R.id.edt_join_pw);
        edt_join_name = findViewById(R.id.edt_join_name);
        edt_join_tel = findViewById(R.id.edt_join_tel);
        edt_join_addr = findViewById(R.id.edt_join_addr);
        shelter_check = findViewById(R.id.shelter_check);
        btn_join = findViewById(R.id.btn_join);
        btn_id_check = findViewById(R.id.btn_id_check);

        btn_id_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest(v);
            }
        });
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest(v);
            }
        });






    }
    public void sendRequest(View v) {
        // Voolley Lib 새료운 요청객체 생성

        String url = "";
        queue = Volley.newRequestQueue(getApplicationContext());
        if (v.equals(btn_join)) {
            url = "http://211.227.224.206:8081/YB_Project/Join";
        } else if (v.equals(btn_id_check)) {
            url = "http://211.227.224.206:8081/YB_Project/Join_id_check";
        }
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);
                if (v.equals(btn_join)) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        String result = jsonObject.getString("isCheck");
                        Log.v("resultValue", result);
                        if (result.equals("true")) {
                            Intent intent = new Intent(getApplicationContext(), Sidebar.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "회원가입 실패..", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (v.equals(btn_id_check)) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        idcheck = jsonObject.getString("isCheck");
                        Log.v("iii", idcheck);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                if (idcheck.equals("true")) {
                    tv_id_check.setText("X");
                } else if (idcheck.equals("false")) {
                    tv_id_check.setText("O");
                } else {
                    tv_id_check.setText("no");
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

                if (v.equals(btn_join)) {
                    if (shelter_check.isChecked()) {
                        result = "1";
                    } else {
                        result = "2";
                    }

                    params.put("join_id", edt_join_id.getText().toString());
                    params.put("join_pw", edt_join_pw.getText().toString());
                    params.put("join_name", edt_join_name.getText().toString());
                    params.put("join_tel", edt_join_tel.getText().toString());
                    params.put("join_addr", edt_join_addr.getText().toString());
                    params.put("join_check", result);


                    Log.v("join_id", edt_join_id.getText().toString());
                    Log.v("join_check", result);


                } else if (v.equals(btn_id_check)) {
                    params.put("join_id", edt_join_id.getText().toString());
                }
                return params;

            }
        };

        queue.add(stringRequest);
    }
}