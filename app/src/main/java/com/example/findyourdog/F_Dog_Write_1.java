package com.example.findyourdog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class F_Dog_Write_1 extends AppCompatActivity {

    private TextView app_name4, tv_info, tv_tel, tv_date, tv_where, tv_img, tv_time;
    private TextView tv_star6, tv_star7, tv_star8, tv_star9, tv_star10;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_f_picture_plus, btn_f_next, btn_f_camera;
    private EditText edt_find, edt_tel, edt_where, edt_time;
    private ImageView img_f_picture;
    private StringRequest stringRequest;
    private RequestQueue queue;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_1);

        app_name4 = findViewById(R.id.tv_appname);
        tv_info = findViewById(R.id.tv_info);
        tv_tel = findViewById(R.id.tv_tel);
        tv_date = findViewById(R.id.tv_l_date);
        tv_where = findViewById(R.id.tv_where);
        tv_img = findViewById(R.id.tv_img);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_f_picture_plus = findViewById(R.id.btn_f_picture_plus);
        edt_find = findViewById(R.id.edt_find);
        edt_tel = findViewById(R.id.edt_place);
        edt_where = findViewById(R.id.edt_time);
        tv_time = findViewById(R.id.tv_l_time);
        edt_time = findViewById(R.id.edt_time);
        tv_star6 = findViewById(R.id.tv_star6);
        tv_star7 = findViewById(R.id.tv_star7);
        tv_star8 = findViewById(R.id.tv_star8);
        tv_star9 = findViewById(R.id.tv_star9);
        tv_star10 = findViewById(R.id.tv_star10);
        img_f_picture = findViewById(R.id.img_f_picture);
        btn_f_camera = findViewById(R.id.btn_f_camera);
        btn_f_next = findViewById(R.id.btn_f_next);

        btn_f_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_f_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1111);
            }

        });

        btn_f_picture_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1000);
            }
        });


    }

    public void takePicture() {
        if (file == null) {
            file = createfile();
        }
    }

    private File createfile() {
        String filename = "capture.jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File outFile = new File(storageDir,filename);


        return outFile;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    img_f_picture.setImageBitmap(img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
        } else if(requestCode == 1111 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Log.v("picture",extras.get("data")+"");
            img_f_picture.setImageBitmap(imageBitmap);
            byte[] img_ =  bitmapToByteArray(imageBitmap);
            for (int i =0; i<img_.length; i++){
                Log.v("picture",img_[i]+"");
            }


//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//            byte[] byteArray = byteArrayOutputStream .toByteArray();
//            for (int i=0; i<byteArray.length; i++){
//                Log.v("picture",byteArray[i]+"");
//            }

        }

    }
//    public void sendRequest(){
//        // Voolley Lib 새료운 요청객체 생성
//        queue = Volley.newRequestQueue(getApplicationContext());
//        String url = "http://211.227.224.206:8081/YB_Project/Login";
//        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            // 응답데이터를 받아오는 곳
//            @Override
//            public void onResponse(String response) {
//                Log.v("resultValue",response);
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    Log.v("resultValue",response);
//
//                    String id = jsonObject.getString("id");
//                    String pw = jsonObject.getString("pw");
//                    String name = jsonObject.getString("name");
//                    int membercode = jsonObject.getInt("membercode");
//                    int tel = jsonObject.getInt("tel");
//                    String address = jsonObject.getString("address");
//
//                    MemberDTO dto = new MemberDTO(id,pw,name,membercode,tel,address);
//
//
//                    Log.v("resultValue", String.valueOf(dto));
//                    if (id.equals(edt_login_id.getText().toString())){
//
//                        PreferenceManager.setString(getApplicationContext(),"id",dto.getId());
//
//                        Intent intent = new Intent(getApplicationContext(),Main.class);
//                        startActivity(intent);
//
//                        Log.v("resultValue","로그인성공");
//                    }else{
//                        Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT).show();
//                        Log.v("resultValue","로그인실패");
//                    }
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
//        }){
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
//                params.put("login_id", edt_login_id.getText().toString());
//                params.put("login_pw", edt_login_pw.getText().toString());
//
//                Log.v("login_id",edt_login_id.getText().toString());
//                Log.v("login_pw",edt_login_pw.getText().toString());
//
//
//                return params;
//            }
//        };
//
//        queue.add(stringRequest);
//    }
public byte[] bitmapToByteArray( Bitmap bitmap ) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        bitmap.compress( Bitmap.CompressFormat.JPEG, 100, stream) ;
        byte[] byteArray = stream.toByteArray() ;
        return byteArray ;
    }

}