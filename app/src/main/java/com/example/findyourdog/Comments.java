package com.example.findyourdog;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

public class Comments extends AppCompatActivity {
    private RequestQueue queue;
    private StringRequest stringRequest;
    private Button btn_write_review;
    private EditText edt_write_review;
    private String result ;
    private ListView listView;
    private CommentAdapter adapter;

    public ArrayList<String[]> commentlist = new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        btn_write_review = findViewById(R.id.btn_write_review);
        edt_write_review = findViewById(R.id.edt_write_review);

        listView = (ListView) findViewById(R.id.comment_listview);
        adapter = new CommentAdapter();
        showRequest();

        btn_write_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });


    }
    public void sendRequest(){
        // Voolley Lib 새료운 요청객체 생성
        queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://211.63.240.26:8081/YB/CommentWriteService";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    result = jsonObject.getString("isCheck");
                    if(result.equals("true")){
                        Log.v("댓글등록","댓글등록완료");
                    }else {
                        Log.v("댓글등록","댓글등록실패");
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
                String id = PreferenceManager.getString(getApplicationContext(),"id");


                params.put("edt_write_review", edt_write_review.getText().toString());
                String board_num = getIntent().getStringExtra("board_num");

                params.put("board_num", board_num);
                params.put("id", id);

                Log.v("review",board_num);
                Log.v("review",edt_write_review.getText().toString());
                Log.v("id",id);



                return params;
            }
        };


        queue.add(stringRequest);
    }
    public void showRequest(){
        // Voolley Lib 새료운 요청객체 생성
        queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://211.63.240.26:8081/YB/CommentViewService";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.v("댓글","리스폰");
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String comments = jsonObject.getString("comments");


                        String[] list = {id, comments};
                        commentlist.add(list);
                    }
                    for (int i = 0; i < commentlist.size(); i++){
                        Log.v("무야~호", commentlist.get(i)[0]+commentlist.get(i)[1]);
                        adapter.addItem(new CommentItem(commentlist.get(i)[0],commentlist.get(i)[1]));
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

            // 보낼 데이터를 저장하는 곳
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                String id = PreferenceManager.getString(getApplicationContext(),"id");

                String board_num = getIntent().getStringExtra("board_num");

                params.put("board_num", board_num);

                Log.v("review",board_num);



                return params;
            }
        };


        queue.add(stringRequest);
    }
    public class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();
        @Override
        public int getCount() { return items.size(); }

        @Override
        public Object getItem(int position) { return items.get(position); }
        @Override
        public long getItemId(int position) { return 0; }

        public void addItem(CommentItem item) { items.add(item); }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Context context = parent.getContext();
            CommentItem commentItem = items.get(position);

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.comments_listview,parent,false);
            }

            TextView tv_id = convertView.findViewById(R.id.tv_id);
            TextView tv_comment = convertView.findViewById(R.id.tv_comment);


            tv_id.setText(commentItem.getId());
            tv_comment.setText(commentItem.getComment());
            Log.v("무야~호", commentItem.getId()+commentItem.getComment());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                }
            });

            return convertView;

        }
    }
}