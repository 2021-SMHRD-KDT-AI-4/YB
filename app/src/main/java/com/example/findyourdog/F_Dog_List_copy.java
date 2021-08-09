package com.example.findyourdog;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.findyourdog.databinding.ActivityFDogListCopyBinding;
import com.example.findyourdog.databinding.ActivityLoginBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class F_Dog_List_copy extends Fragment implements View.OnClickListener {

    private TextView tv_page1, tv_page2, tv_page3, tv_page4, tv_page5;
    private ImageButton imgbtn_f_write;
    private Context pageContext;

    private String TAG = F_Dog_List_copy.class.getSimpleName();

    private GridView gridView =null;
    private GridViewAdapter adapter =null;

    private RequestQueue queue;
    private StringRequest stringRequest;

    public ArrayList<String[]> board = new ArrayList<String[]>();

    public F_Dog_List_copy(Context pageContext) {
        this.pageContext = pageContext;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_f_dog_list_copy, container, false);

        imgbtn_f_write = fragment.findViewById(R.id.imgbtn_f_write);

        imgbtn_f_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),F_Dog_Write_1.class);
                startActivity(intent);
            }
        });

        gridView = (GridView) fragment.findViewById(R.id.gv_find);
        adapter = new GridViewAdapter();


        // 서버로부터 board 테이블의 게시물 읽어올 것을 요청
        sendRequest();

        return fragment;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), F_Dog_Write_1.class);
        startActivity(intent);
    }

    public void sendRequest(){

        queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        String url = "http://211.63.240.26:8081/YB/BoardService";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String status = jsonObject.getString("status");
                        if(!status.equals("0")){ // status가 1인 반려견은 보여주지않음
                            continue;
                        }
                        String board_num = jsonObject.getString("board_num");
                        String id = jsonObject.getString("id");
                        String board_type = jsonObject.getString("board_type");

                        String picture = jsonObject.getString("picture");
                        String gender= jsonObject.getString("gender");
                        String age = jsonObject.getString("age");
                        String color = jsonObject.getString("color");
                        String kind = jsonObject.getString("kind");
                        String weight = jsonObject.getString("weight");
                        String missing_date = jsonObject.getString("missing_date");
                        String missing_time = jsonObject.getString("missing_time");
                        String notice = jsonObject.getString("notice");
                        String shelter = jsonObject.getString("shelter");
                        String city = jsonObject.getString("city");
                        String place = jsonObject.getString("place");
                        String tel = jsonObject.getString("tel");
                        String content = jsonObject.getString("content");

                        String[] list = {board_num, id, board_type, status, picture,gender, age, color, kind, weight, missing_date, missing_time, notice, shelter, city, place,tel, content};
                        board.add(list);

                    }

                    for (int i=0 ; i < board.size(); i++ ){
                        adapter.addItem(new FindItem(board.get(i)[4], board.get(i)[12], board.get(i)[8], board.get(i)[16], board.get(i)[13], board.get(i)[2]));
                        Log.v("filename",board.get(i)[4]+"");
                    }

                    //리스트뷰에 Adapter 설정
                    gridView.setAdapter(adapter);


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
            @Override // response를 UTF8로 변경해주는 소스코드
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

    // 그리드뷰 어댑터
    class GridViewAdapter extends BaseAdapter {
        ArrayList<FindItem> list = new ArrayList<FindItem>();

        @Override
        public int getCount() {
            return list.size();
        }

        public void addItem(FindItem item) { list.add(item); }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {

            Log.d(TAG, "getView() - [ "+position+" ] 시작 ");
            Context context = viewGroup.getContext();
            FindItem findItem = list.get(position);


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.f_gridview, viewGroup, false);

            ImageView img_f_dog_picture = (ImageView) convertView.findViewById(R.id.img_f_dog_picture);

            TextView tv_f_date = (TextView) convertView.findViewById(R.id.tv_f_date);
            TextView tv_f_kind = (TextView) convertView.findViewById(R.id.tv_f_kind);
            TextView tv_f_place = (TextView) convertView.findViewById(R.id.tv_f_place);
            TextView tv_f_time = (TextView) convertView.findViewById(R.id.tv_f_time);

            TextView f_date = (TextView) convertView.findViewById(R.id.f_date);
            TextView f_place = (TextView) convertView.findViewById(R.id.f_place);
            TextView f_time = (TextView) convertView.findViewById(R.id.f_time);

            setPic(findItem.getFilename(),img_f_dog_picture);
            tv_f_date.setText(findItem.getNotice());
            tv_f_kind.setText(findItem.getKind());
            tv_f_place.setText(findItem.getShelter());
            tv_f_time.setText(findItem.getTel());

            if(findItem.getBoard_type().equals("3")) { // 보호소api 게시글일 경우
                f_date.setText("공고기간");
                f_place.setText("관할보호센터");
                f_time.setText("연락처");

            }

            return convertView;
        }

        public void setPic(String filename, ImageView imageView) {

            String urlStr = "http://211.63.240.26:8081/YB/ImageService?filename="+filename;
            ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
            imageLoadTask.execute();

        }

    }

}