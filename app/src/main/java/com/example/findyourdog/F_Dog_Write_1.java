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
import android.widget.ImageButton;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class F_Dog_Write_1 extends AppCompatActivity {

    private TextView tv_f_day,tv_f_time,tv_f_picture,tv_f_tel,tv_f_place,tv_star6,
            tv_star7, tv_star8, tv_star9, tv_star10;
    private Button btn_f_picture_plus, btn_f_next, btn_f_camera;
    private EditText edt_f_day, edt_f_tel, edt_f_place, edt_f_time;
    private ImageView img_f_picture;
    private Spinner spn_f_sido;
    private ImageButton imgbtn_f_back2;

    private StringRequest stringRequest;
    private RequestQueue queue;
    Calendar myCalendar = Calendar.getInstance();
    File file;

    Random r = new Random();
    String id = "";
    int rand = 0;
    String f_filename="";
    byte[] bitarr;
    String[] items = new String[]{"???/???","??????","??????","??????","??????","??????","??????","??????","??????",
            "??????","??????","??????","??????","??????","??????","??????","??????","??????"};

    // ?????? ????????? ??????
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
        imgbtn_f_back2 = findViewById(R.id.imgbtn_f_back2);

        imgbtn_f_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main.class);
                finish();
                startActivity(intent);
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.spn_f_sido);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );

        // ???????????? ?????? ??? ?????? ???
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // ???????????? ????????? ??????
        spinner.setAdapter(adapter);
        // ??????????????? ?????? ?????? ?????? ????????? ??????


        // ?????? ????????? ?????? ????????? ????????? ???????????? ?????? ??????
        edt_f_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(F_Dog_Write_1.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // ?????? ?????? ???????????? ????????????
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
                        // ????????? ????????? 12??? ???????????? "PM"?????? ?????? ??? -12???????????? ?????? (ex : PM 6??? 30???)
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            state = "PM";
                        }
                        // EditText??? ????????? ?????? ??????
                        edt_f_time.setText(state + " " + selectedHour + "??? " + selectedMinute + "???");
                    }
                }, hour, minute,  true); // true??? ?????? 24?????? ????????? TimePicker ??????
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });



        btn_f_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = PreferenceManager.getString(getApplicationContext(),"id");
                rand = r.nextInt(1000);
                f_filename = id+"_"+rand+".jpg";
                Log.v("f_filename1", f_filename);
                sendRequest();

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
                    bitarr = BitmaptoArray(img);
                    in.close();
                    img_f_picture.setImageBitmap(img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "?????? ?????? ??????", Toast.LENGTH_LONG).show();
        } else if(requestCode == 1111 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            bitarr = BitmaptoArray(imageBitmap);
            img_f_picture.setImageBitmap(imageBitmap);
        }

    }

    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";    // ????????????   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.edt_f_day);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }

    public void sendRequest() {
        // Voolley Lib ????????? ???????????? ??????
        queue = Volley.newRequestQueue(this);
        String url = "http://211.63.240.26:5002/testimg";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {
                Log.v("resultValue", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String dogBreed = jsonObject.getString("dog_breed");
                    Log.v("dogbreed",dogBreed);
                    if (dogBreed != null) {

                        Intent intent1 = new Intent(getApplicationContext(), F_Dog_Write_2.class);
                        String e_f_day = edt_f_day.getText().toString();
                        String e_f_tel = edt_f_tel.getText().toString();
                        String f_city = spn_f_sido.getSelectedItem().toString();
                        int cityNum = Arrays.asList(items).indexOf(f_city);
                        Log.v("citynum",cityNum+"");
                        String e_f_place = edt_f_place.getText().toString();
                        String e_f_time = edt_f_time.getText().toString();
                        f_city = f_city + " "+ e_f_place;
                        intent1.putExtra("bitarr",bitarr);

                        intent1.putExtra("f_id",id);
                        intent1.putExtra("f_type","2");
                        intent1.putExtra("f_filename",f_filename);
                        intent1.putExtra("f_Day",e_f_day);
                        intent1.putExtra("f_tel",e_f_tel);
                        intent1.putExtra("f_city",f_city);
                        intent1.putExtra("citynum",cityNum+"");
                        intent1.putExtra("f_place",e_f_place);
                        intent1.putExtra("f_time",e_f_time);
                        intent1.putExtra("f_breed",dogBreed);

                        startActivity(intent1);
                        finish();
                    }

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

                BitmapDrawable drawable = (BitmapDrawable) img_f_picture.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String imgStr = BitmapToBase64(bitmap);

                params.put("f_filename",f_filename);
                params.put("bitmap", imgStr);

                return params;
            }
        };
        queue.add(stringRequest);
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