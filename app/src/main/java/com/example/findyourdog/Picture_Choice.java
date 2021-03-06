package com.example.findyourdog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Picture_Choice extends AppCompatActivity {

    private ImageView img_menu, img_picture1, img_picture2, img_picture3, img_picture4;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_find;
    private TextView tv_appname, tv_picture_result, tv_pic1_info, tv_pic2_info;
    private TextView tv_pic3_info, tv_pic4_info;
    private CheckBox cb_7, cb_8, cb_9, cb_10;
    private StringRequest stringRequest;
    private ListView listView;
    private RequestQueue queue;
    private PictureAdapter pictureAdapter;

    public ArrayList<String[]> picture_list = new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_choice);
        listView = findViewById(R.id.picture_listview);
        pictureAdapter = new PictureAdapter();
        showRequest();



    }

    public void showRequest() {
        // Voolley Lib ????????? ???????????? ??????
        queue = Volley.newRequestQueue(getApplicationContext());
        //211.63.240.26 ??????
        //211.227.224.206 ??????
        String url = "http://211.63.240.26:8081/YB/PictureResultShowService";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {
                if (response.equals("[]")) {

                    Intent intent = new Intent(getApplicationContext(),Picture_Search_Result.class);
//                    overridePendingTransition(0, 0); //????????? ??????????????? ?????????
//                    startActivity(intent);
//                    overridePendingTransition(0, 0); //????????? ??????????????? ?????????
                    finish();
                    startActivity(intent);
                }

                Log.v("???????????????", response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String picture = jsonObject.getString("picture");
                        String kind = jsonObject.getString("kind");
                        String gender = jsonObject.getString("gender");
                        Log.v("????????????", "????????? : " + picture + "?????? : " + kind + "?????? : " + gender);

                        String[] list = {kind, picture, gender};

                        picture_list.add(list);

                    }
                    for (int i = 0; i < picture_list.size(); i++) {

                        Log.v("??????~???", picture_list.get(i)[0] + picture_list.get(i)[1] + picture_list.get(i)[2]);
                        pictureAdapter.addItem(new PictureItem(picture_list.get(i)[0], picture_list.get(i)[1], picture_list.get(i)[2]));

                    }
                    listView.setAdapter(pictureAdapter);

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
                String id = PreferenceManager.getString(getApplicationContext(), "id");

                params.put("id", id);
                Log.v("resultValue", id);


                return params;
            }
        };
        queue.add(stringRequest);
    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder=" + "BoardPic" + "&filename=" + filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }//

    public class PictureAdapter extends BaseAdapter {
        ArrayList<PictureItem> items = new ArrayList<PictureItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(PictureItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Context context = parent.getContext();
            PictureItem pictureItem = items.get(position);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.picture_listview, parent, false);
            }

            ImageView img_picture = convertView.findViewById(R.id.img_picture);
            TextView tv_kind = convertView.findViewById(R.id.tv_kind);
            TextView tv_gender = convertView.findViewById(R.id.tv_gender);

            setPic(pictureItem.getFilename(), img_picture);
            tv_kind.setText(pictureItem.getKind());
            tv_gender.setText(pictureItem.getGender());

            Log.v("??????~???", pictureItem.getFilename() + pictureItem.getKind() + pictureItem.getGender());


            convertView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Picture_Choice.this);
                    builder.setTitle("??????");
                    builder.setMessage("?????? ???????????? ?????? ???????????????????");


                    builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {



                            String filename = items.get(position).getFilename();

                            detailrequest(filename);

                        }
                    });
                    builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    return false;
                }
            });

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Picture_Choice.this);
                    builder.setTitle("??????");
                    builder.setMessage("???????????? ??????????????????? ????????? ????????? ???????????? ????????? ???????????????.");


                    builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            String id = PreferenceManager.getString(getApplicationContext(), "id");
                            String filename = items.get(position).getFilename();

                            sendRequest(id, filename);

                        }
                    });
                    builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();


//                    String dog_name = items.get(position).getName();
//                    String filename = items.get(position).getFilename();
//
//

//                    Intent intent = new Intent(Dog_Nose_Print_Choice.this, Dog_Nose_print_Search_list_Fail.class);
//                    startActivity(intent);

                }
            });

            return convertView;
        }
    }

    public void sendRequest(String id, String filename) {
        // Voolley Lib ????????? ???????????? ??????
        queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://211.63.240.26:8081/YB/PictureControll";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {
                Log.v("resultValue : ????????????", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String result = jsonObject.getString("isCheck");
                    Log.v("resultValue", result);
                    if (result.equals("true")) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(Picture_Choice.this);
                        builder.setTitle("??????");
                        builder.setMessage("????????? ?????????????????????.");

                        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = getIntent();
                                finish(); //?????? ???????????? ?????? ??????
                                overridePendingTransition(0, 0); //????????? ??????????????? ?????????
                                startActivity(intent); //?????? ???????????? ????????? ??????
                                overridePendingTransition(0, 0); //????????? ??????????????? ?????????
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();


                    } else if (result.equals("false")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Picture_Choice.this);
                        builder.setTitle("??????");
                        builder.setMessage("??????????????? ?????????????????????.");

                        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = getIntent();
                                finish(); //?????? ???????????? ?????? ??????
                                overridePendingTransition(0, 0); //????????? ??????????????? ?????????
                                startActivity(intent); //?????? ???????????? ????????? ??????
                                overridePendingTransition(0, 0); //????????? ??????????????? ?????????
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
                Log.v("resultVale", "?????? ??? : " + id + "  " + filename);


                params.put("id", id);
                params.put("filename", filename);


                return params;
            }
        };


        queue.add(stringRequest);
    }
    public void detailrequest(String filename) {
        // Voolley Lib ????????? ???????????? ??????
        queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://211.63.240.26:8081/YB/PictureDetailService";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {
                Log.v("resultValue : ?????? detail", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String board_num = jsonObject.getString("board_num");
//                    String id = PreferenceManager.getString(getApplicationContext(),"id");
                    String id = jsonObject.getString("id");
                    String board_type = jsonObject.getString("board_type");
                    String picture = jsonObject.getString("picture");
                    String gender= jsonObject.getString("gender");
                    String age = jsonObject.getString("age");
                    String color = jsonObject.getString("color");
                    String kind = jsonObject.getString("kind");
                    String weight = jsonObject.getString("weight");
                    String place = jsonObject.getString("place");
                    String missing_date = "";
                    if (jsonObject.isNull("missing_date")){
                        missing_date = "";
                    }else {
                        missing_date = jsonObject.getString("missing_date");

                    }
                    String missing_time = "";
                    if (jsonObject.isNull("missing_time")){
                        missing_time = "";
                    }else {
                        missing_time = jsonObject.getString("missing_time");

                    }

                    String notice = "";
                    if(jsonObject.isNull("notice")){
                        notice = "";
                    }else {
                        notice = jsonObject.getString("notice");
                    }
                    String shelter = "";
                    if(jsonObject.isNull("shelter")){
                        shelter = "";
                    }else {
                        shelter = jsonObject.getString("shelter");
                    }


                    String city = jsonObject.getString("city");
                    String tel = jsonObject.getString("tel");
                    String content = jsonObject.getString("content");

                    Intent intent = new Intent(getApplicationContext(),F_Dog_Detail.class);
                    intent.putExtra("id",id);
                    intent.putExtra("picture",picture);
                    intent.putExtra("gender",gender);
                    intent.putExtra("age",age);
                    intent.putExtra("color",color);
                    intent.putExtra("kind",kind);
                    intent.putExtra("weight",weight);
                    intent.putExtra("missing_date",missing_date);
                    intent.putExtra("missing_time",missing_time);
                    intent.putExtra("notice",notice);
                    intent.putExtra("shelter",shelter);
                    intent.putExtra("place",place);
                    intent.putExtra("tel",tel);
                    intent.putExtra("content",content);
                    intent.putExtra("board_num",board_num);
                    startActivity(intent);

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
                Log.v("resultVale", "?????? ??? : "  + filename);



                params.put("filename", filename);


                return params;
            }
        };


        queue.add(stringRequest);
    }

}