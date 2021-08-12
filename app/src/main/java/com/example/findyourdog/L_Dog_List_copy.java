package com.example.findyourdog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class L_Dog_List_copy extends Fragment implements View.OnClickListener {

    private Context pageContext;

    private TextView tv_page6,tv_page7,tv_page8,tv_page9,tv_page10;
    private ImageButton imgbtn_l_write;

    private String TAG = L_Dog_List_copy.class.getSimpleName();

    private GridView gridView =null;
    private GridViewAdapter adapter =null;

    private RequestQueue queue;
    private StringRequest stringRequest;

    public ArrayList<String[]> lost = new ArrayList<String[]>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_l_dog_list_copy, container, false);

        imgbtn_l_write = fragment.findViewById(R.id.imgbtn_l_write);

        imgbtn_l_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("cc","click");
                Intent intent = new Intent(getActivity(), L_Dog_Write1.class);
                startActivity(intent);
            }
        });

        gridView = (GridView) fragment.findViewById(R.id.gv_lost);

        adapter = new GridViewAdapter();
        sendRequest();

        return fragment;
    }

    @Override
    public void onClick(View v) {

    }

    public void sendRequest(){

        queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        String url = "http://211.63.240.26:8081/YB/FindService";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.v("resultValue Lost",response);

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
                        if(!board_type.equals("1")){
                            continue;
                        }
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

                        Log.v("lost : ", picture+" "+gender+" "+content);
                        String[] list = {board_num, id, board_type, status, picture,gender, age, color, kind, weight, missing_date, missing_time, notice, shelter, city, place,tel, content};
                        lost.add(list);

                    }

                    for (int i=0 ; i < lost.size(); i++ ){
                        adapter.addItem(new FindItem(lost.get(i)[0], lost.get(i)[1], lost.get(i)[2], lost.get(i)[3], lost.get(i)[4],
                                lost.get(i)[5], lost.get(i)[6],lost.get(i)[7], lost.get(i)[8], lost.get(i)[9], lost.get(i)[10],
                                lost.get(i)[11], lost.get(i)[12],lost.get(i)[13], lost.get(i)[14], lost.get(i)[15],lost.get(i)[16], lost.get(i)[17]));

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
            convertView = inflater.inflate(R.layout.l_gridview, viewGroup, false);

            ImageView img_l_dog_picture = (ImageView) convertView.findViewById(R.id.img_l_dog);

            TextView tv_l_kind = (TextView) convertView.findViewById(R.id.tv_l_kind);
            TextView tv_l_date = (TextView) convertView.findViewById(R.id.tv_l_date);
            TextView tv_l_place = (TextView) convertView.findViewById(R.id.tv_l_place);
            TextView tv_l_time = (TextView) convertView.findViewById(R.id.tv_l_time);

            setPic(findItem.getPicture(),img_l_dog_picture);
            tv_l_kind.setText(findItem.getKind());
            tv_l_date.setText(findItem.getMissing_date());
            tv_l_place.setText(findItem.getPlace());
            tv_l_time.setText(findItem.getMissing_time());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v("click : ","click!!"+list.get(position).getShelter());
                    Intent intent = new Intent(getActivity(), L_Dog_Detail.class);

                    intent.putExtra("id", list.get(position).getId());
                    intent.putExtra("picture",list.get(position).getPicture());
                    intent.putExtra("gender", list.get(position).getGender());
                    intent.putExtra("age", list.get(position).getAge());
                    intent.putExtra("color", list.get(position).getColor());
                    intent.putExtra("kind", list.get(position).getKind());
                    intent.putExtra("weight", list.get(position).getWeight());
                    intent.putExtra("missing_date",list.get(position).getMissing_date());
                    intent.putExtra("missing_time",list.get(position).getMissing_time());
                    intent.putExtra("notice", list.get(position).getNotice());
                    intent.putExtra("shelter", list.get(position).getShelter());
                    intent.putExtra("place", list.get(position).getPlace());
                    intent.putExtra("tel", list.get(position).getTel());
                    intent.putExtra("content", list.get(position).getContent());
                    intent.putExtra("board_num",list.get(position).getBoard_num());

                    startActivity(intent);


                }
            });


            return convertView;
        }

        public void setPic(String filename, ImageView imageView) {

            String urlStr = "http://211.63.240.26:8081/YB/ImageService?folder="+"BoardPic"+"&filename="+filename;
            ImageLoadTask imageLoadTask = new ImageLoadTask(urlStr, imageView);
            imageLoadTask.execute();

        }

    }

}