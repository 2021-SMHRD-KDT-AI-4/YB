package com.example.findyourdog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dog_Nose_Print_Choice extends AppCompatActivity {

    private ImageView img_menu, img_nose1, img_nose2;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_want_find;
    private TextView tv_appname, tv_dog_nose_print_choice, tv_img1_name, tv_img2_name;

    private String TAG = Dog_Nose_Print_Choice.class.getSimpleName();

    private ListView listView;
    private ListItemAdapter adapter = new ListItemAdapter();


    private RequestQueue queue;
    private StringRequest stringRequest;

    public ArrayList<String[]> userList = new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_choice);

//        listView = findViewById(R.id.listview);
//
//
//        listView.setAdapter(adapter);
//
        sendRequest();

    }
    public void sendRequest(){

        queue = Volley.newRequestQueue(getApplicationContext());

        String n_id = PreferenceManager.getString(getApplicationContext(),"id");
        String url = "http://211.63.240.26:8081/YB/UserNoseService?id="+n_id;

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("무야호의 힘",response);
                String filename ="";
                String name ="";
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        filename = jsonObject.getString("picture");
                        name = jsonObject.getString("dog_name");

                        String[] list = {filename, name};
                        userList.add(list);
                    }
                    for (int i=0 ; i < userList.size(); i++ ){
                        adapter.addItem(new NoseItem(userList.get(i)[0], userList.get(i)[1]));
                    }
                    listView.setAdapter(adapter);
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
        };
        queue.add(stringRequest);
    }

    public class ListItemAdapter extends BaseAdapter{
        ArrayList<NoseItem> items = new ArrayList<NoseItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(NoseItem item) { items.add(item); }

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
            NoseItem noseItem = items.get(position);

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.coustom_listview,parent,false);
            }

            ImageView img_dog_nose_print = convertView.findViewById(R.id.img_dog_nose_print);
            TextView tv_dog_name = convertView.findViewById(R.id.tv_dog_name);

            setPic(noseItem.getFilename(),img_dog_nose_print);
            tv_dog_name.setText(noseItem.getName());

            Log.v("무야~호", noseItem.getFilename()+noseItem.getName());


            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                // 비문선택시
                }
            });

            return convertView;
        }
    }

    public void setPic(String filename, ImageView imageView) {

        String urlStr = "http://211.63.240.26:8081/YB/BoardService?filename="+filename;
        ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
        imageLoadTask.execute();

    }








//    public void sendRequest(){
//        // Voolley Lib 새료운 요청객체 생성
//        queue = Volley.newRequestQueue(getApplicationContext());
//        String url = "http://211.227.224.206:8081/YB/UserNoseService";
//        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            // 응답데이터를 받아오는 곳
//            @Override
//            public void onResponse(String response) {
//                Log.v("resultValue",response);
//                String filename = "";
//                String name = "";
//
//                try {
//                    JSONArray jsonArray = new JSONArray(response);
//                    for (int i =0; i <jsonArray.length(); i++){
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        filename = jsonObject.getString("picture");
//                        name = jsonObject.getString("dog_name");
//                        Log.v("filename",filename);
//
//                        String[] list = {filename, name};
//                        userList.add(list);
//
//                    }
//
//                    for (int i=0 ; i < userList.size(); i++ ){
//                        adapter.addItem(new NoseItem(userList.get(i)[0], userList.get(i)[1]));
//
//                    }
//
//                    listView.setAdapter(adapter);
//
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
//                String id = PreferenceManager.getString(getApplicationContext(),"id");
//
//                Log.v("resultValue id ",id);
//                params.put("id",id);
//                return params;
//            }
//        };
//
//
//        queue.add(stringRequest);
//    }

}