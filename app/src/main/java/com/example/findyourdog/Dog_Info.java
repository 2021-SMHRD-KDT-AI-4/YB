package com.example.findyourdog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;

public class Dog_Info extends Fragment {
    private ImageView img_nose_print;
    private Button btn_nose_print_picture_plus,btn_nose_print_camera,btn_profile_ok;
    private EditText edt_info_name,edt_info_sex,edt_info_type;
    private RequestQueue queue;
    private StringRequest stringRequest;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_dog_info, container, false);

        img_nose_print = fragment.findViewById(R.id.img_nose_print);
        btn_nose_print_picture_plus = fragment.findViewById(R.id.btn_nose_print_picture_plus);
        btn_nose_print_camera = fragment.findViewById(R.id.btn_nose_print_camera);
        btn_profile_ok = fragment.findViewById(R.id.btn_profile_ok);
        edt_info_name = fragment.findViewById(R.id.edt_info_name);
        edt_info_sex = fragment.findViewById(R.id.edt_info_sex);
        edt_info_type = fragment.findViewById(R.id.edt_info_type);



        btn_nose_print_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1001);
            }

        });
        btn_nose_print_picture_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1003);
            }
        });
        btn_profile_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { sendRequest(); }
        });



        return fragment;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            img_nose_print.setImageBitmap(imageBitmap);

        }else if (requestCode == 1003 && resultCode == Activity.RESULT_OK){
            InputStream in = null;

            try {
                in = getActivity().getContentResolver().openInputStream(data.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
                Bitmap img = BitmapFactory.decodeStream(in);
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
                img_nose_print.setImageBitmap(img);
        }
    }

    private ContentResolver getContentResolver() {
        return null;
    }
    public void sendRequest(){
        // Voolley Lib 새료운 요청객체 생성
        queue = Volley.newRequestQueue(getActivity());
        String url = "http://211.63.240.26:8081/YB/NosePrintService";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String result = jsonObject.getString("isCheck");
                    Log.v("resultValue",result);
                    if(result.equals("true")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("비문등록").setMessage("비문등록이 완료되었습니다.");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(),Main.class);
                                startActivity(intent);
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }else if (result.equals("false")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("비문등록").setMessage("비문등록이 실패하였습니다.");

                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(),Main.class);
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
                String id = PreferenceManager.getString(getActivity(),"id");

                BitmapDrawable drawable = (BitmapDrawable) img_nose_print.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String filename = BitmapToBase64(bitmap);
                Log.v("bitmapp",filename);

                params.put("dog_name", edt_info_name.getText().toString());
                params.put("dog_gender", edt_info_sex.getText().toString());
                params.put("dog_kind", edt_info_type.getText().toString());
                params.put("id", id);
                params.put("dog_picture", filename);




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


}