package com.example.findyourdog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Side_bar_MyPage extends AppCompatActivity {

    private ListView listView;

    private ImageView img_menu;
    private TextView app_name, tv_mypage, tv_mypage_dog_nose;
    private TextView tv_mypage_dog_name, tv_mypage_ok;
    private Button btn_nose_print_go;
    private StringRequest stringRequest;
    private RequestQueue queue;
    private MypageAdapter mypageAdapter;



    public ArrayList<String[]> mypagelist = new ArrayList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar_my_page);
        mypageAdapter = new MypageAdapter();
        listView =  findViewById(R.id.mypage_listview);
        showRequest();


        btn_nose_print_go =findViewById(R.id.btn_nose_print_go);
        btn_nose_print_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Main.class);
                startActivity(intent);

            }
        });

    }

    public void showRequest(){
        // Voolley Lib 새료운 요청객체 생성
        queue = Volley.newRequestQueue(getApplicationContext());
        //211.63.240.26 연지
        //211.227.224.206 창현
        String url = "http://211.63.240.26:8081/YB/MypageNosePrintService";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("마이페이지",response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.v("마이페이지",response);
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String dog_name = jsonObject.getString("dog_name");
                        String str = "등록완료";

                        Log.v("마이페이지확인","개이름 : "+dog_name+"등록여부 : "+str);


                        String[] list = {dog_name, str};

                        mypagelist.add(list);

                    }
                    for (int i = 0; i < mypagelist.size(); i++){

                        Log.v("무야~호", mypagelist.get(i)[0]+mypagelist.get(i)[1]);
                        mypageAdapter.addItem(new MypageItem(mypagelist.get(i)[0],mypagelist.get(i)[1]));
                    }
                    listView.setAdapter(mypageAdapter);

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


                params.put("id", id);
                Log.v("resultValue","id : "+id);



                return params;
            }
        };


        queue.add(stringRequest);
    }
    public class MypageAdapter extends BaseAdapter {
        ArrayList<MypageItem> items = new ArrayList<MypageItem>();
        @Override
        public int getCount() { return items.size(); }

        @Override
        public Object getItem(int position) { return items.get(position); }
        @Override
        public long getItemId(int position) { return 0; }

        public void addItem(MypageItem item) { items.add(item); }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Context context = parent.getContext();
            MypageItem mypageItem = items.get(position);

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.mypage_listview,parent,false);
            }

            TextView tv_my_dog_name = convertView.findViewById(R.id.tv_my_dog_name);
            TextView tv_my_dog_noseprint_ = convertView.findViewById(R.id.tv_my_dog_noseprint);


            tv_my_dog_name.setText(mypageItem.getDog_name());
            tv_my_dog_noseprint_.setText(mypageItem.getResult());
//            Log.v("무야~호", mypageItem.getDog_name()+mypageItem.getResult());

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