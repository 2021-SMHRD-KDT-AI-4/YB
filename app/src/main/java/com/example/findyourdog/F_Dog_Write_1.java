package com.example.findyourdog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class F_Dog_Write_1 extends AppCompatActivity {

    private TextView tv_f_day,tv_f_time,tv_f_picture,tv_f_tel,tv_f_place,tv_star6,
            tv_star7, tv_star8, tv_star9, tv_star10;
    private Button btn_f_picture_plus, btn_f_next, btn_f_camera;
    private EditText edt_f_day, edt_f_tel, edt_f_place, edt_f_time;
    private ImageView img_f_picture;
    private Spinner spn_f_sido;

    private StringRequest stringRequest;
    private RequestQueue queue;
    Calendar myCalendar = Calendar.getInstance();
    File file;

    String[] items = new String[]{"시/도","서울","부산","대구","인천","광주","세종","대전","울산",
            "경기","강원","충남","충북","전남","전북","경남","경북","제주"};

    // 날짜 구하는 거거
   DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_1);


        edt_f_tel = findViewById(R.id.edt_f_tel);
        edt_f_time = findViewById(R.id.edt_f_time);
        edt_f_place = findViewById(R.id.edt_f_place);
        edt_f_day = findViewById(R.id.edt_f_day);
        btn_f_next = findViewById(R.id.btn_f_next);
        img_f_picture = findViewById(R.id.img_f_picture);
        btn_f_picture_plus = findViewById(R.id.btn_f_picture_plus);
        btn_f_camera = findViewById(R.id.btn_f_camera);
        spn_f_sido = findViewById(R.id.spn_f_sido);


        Spinner spinner = (Spinner) findViewById(R.id.spn_f_sido);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );

        // 드롭다운 클릭 시 선택 창
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);
        // 스피너에서 선택 했을 경우 이벤트 처리


        // 버튼 누르면 날짜 켈린더 나오고 확인하면 날짜 생성
        edt_f_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(F_Dog_Write_1.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // 시간 선택 다이얼로 넘어감감
       edt_f_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(F_Dog_Write_1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "AM";
                        // 선택한 시간이 12를 넘을경우 "PM"으로 변경 및 -12시간하여 출력 (ex : PM 6시 30분)
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            state = "PM";
                        }
                        // EditText에 출력할 형식 지정
                        edt_f_time.setText(state + " " + selectedHour + "시 " + selectedMinute + "분");
                    }
                }, hour, minute,  true); // true의 경우 24시간 형식의 TimePicker 출현
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });



        btn_f_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),F_Dog_Write_2.class);
                startActivity(intent);
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
            img_f_picture.setImageBitmap(imageBitmap);
        }

    }

    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.edt_f_day);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }

    public void sendRequest() {
        // Voolley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        String url = "http://59.0.147.251:5000/testimg";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String dogBreed = jsonObject.getString("dog_breed");
                    Log.v("dogbreed",dogBreed);
                    if (dogBreed != null) {

                        Intent intent = new Intent(getApplicationContext(), F_Dog_Write_2.class);
                        String e_f_Day = edt_f_day.getText().toString();
                        String e_f_tel = edt_f_tel.getText().toString();
                        String f_city = spn_f_sido.getSelectedItem().toString() ;
                        String e_f_place = edt_f_place.getText().toString();
                        String e_f_time = edt_f_time.getText().toString();

                        intent.putExtra("e_f_Day",e_f_Day);
                        intent.putExtra("e_f_tel",e_f_tel);
                        intent.putExtra("f_city",f_city);
                        intent.putExtra("e_f_place",e_f_place);
                        intent.putExtra("e_f_time",e_f_time);
                        intent.putExtra("dogbreed",dogBreed);
                        startActivity(intent);
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

                BitmapDrawable drawable = (BitmapDrawable) img_f_picture.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String imgStr = BitmapToBase64(bitmap);
                String user_id = "sim";

                params.put("user_id",user_id);
                params.put("bitmap", imgStr);
                Log.v("Find", imgStr);

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