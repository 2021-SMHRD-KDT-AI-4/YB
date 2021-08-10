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
import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class P_Dog_list extends Fragment implements View.OnClickListener {

    private Context pageContext;

    private String TAG = P_Dog_list.class.getSimpleName();

    private GridView gv_adopt =null;
    private GridViewAdapter adapter =null;

    private RequestQueue queue;
    private StringRequest stringRequest;

    public ArrayList<String[]> adp = new ArrayList<String[]>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.activity_p_dog_list, container, false);


        gv_adopt = (GridView) fragment.findViewById(R.id.gv_lost);

        adapter = new P_Dog_list.GridViewAdapter();

        // 서버로부터 board 테이블의 게시물 읽어올 것을 요청
        sendRequest();

        return fragment;

    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(getActivity(), F_Dog_Write_1.class);
//        startActivity(intent);
    }

    public void sendRequest(){

        queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        String url = "http://211.63.240.26:8081/YB/AdpService";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);

                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String adp_num = jsonObject.getString("adp_num");
                        String adp_picture = jsonObject.getString("adp_picture");
                        String adp_gender= jsonObject.getString("adp_gender");
                        String adp_age = jsonObject.getString("adp_age");
                        String adp_color = jsonObject.getString("adp_color");
                        String adp_kind = jsonObject.getString("adp_kind");
                        String adp_weight = jsonObject.getString("adp_weight");
                        String adp_shelter = jsonObject.getString("adp_shelter");
                        String adp_addr = jsonObject.getString("adp_addr");
                        String adp_neuter = jsonObject.getString("adp_neuter");
                        String adp_tel = jsonObject.getString("adp_tel");
                        String adp_content = jsonObject.getString("adp_content");

                        String[] list = {adp_num, adp_picture, adp_gender, adp_age,adp_color, adp_kind, adp_weight,
                                adp_shelter, adp_addr, adp_neuter, adp_tel, adp_content};

                        adp.add(list);

                    }

                    for (int i=0 ; i < adp.size(); i++ ){
                        adapter.addItem(new AdpItem(adp.get(i)[0], adp.get(i)[1], adp.get(i)[2], adp.get(i)[3], adp.get(i)[4],
                                adp.get(i)[5], adp.get(i)[6],adp.get(i)[7], adp.get(i)[8], adp.get(i)[9], adp.get(i)[10],
                                adp.get(i)[11]));

                    }

                    //리스트뷰에 Adapter 설정
                    gv_adopt.setAdapter(adapter);


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
        ArrayList<AdpItem> list = new ArrayList<AdpItem>();

        @Override
        public int getCount() {
            return list.size();
        }

        public void addItem(AdpItem item) {
            list.add(item);
        }

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

            Log.d(TAG, "getView() - [ " + position + " ] 시작 ");
            Context context = viewGroup.getContext();
            AdpItem adpItem = list.get(position);


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.a_gridview, viewGroup, false);

            ImageView img_p_dog = (ImageView) convertView.findViewById(R.id.img_p_dog);

            TextView tv_p_kind = (TextView) convertView.findViewById(R.id.tv_p_kind);
            TextView tv_p_weight = (TextView) convertView.findViewById(R.id.tv_p_weight);
            TextView tv_p_shelter = (TextView) convertView.findViewById(R.id.tv_p_shelter);
            TextView tv_p_sex = (TextView) convertView.findViewById(R.id.tv_p_sex);
            TextView tv_p_content = (TextView) convertView.findViewById(R.id.tv_p_content);

            setPic(adpItem.getAdp_picture(), img_p_dog);
            tv_p_kind.setText(adpItem.getAdp_kind());
            tv_p_weight.setText(adpItem.getAdp_weight()+" (kg)");
            tv_p_shelter.setText(adpItem.getAdp_shelter());
            tv_p_sex.setText(adpItem.getAdp_gender());
            tv_p_content.setText(adpItem.getAdp_content());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), P_Dog_Detail.class);

                    intent.putExtra("picture", list.get(position).getAdp_picture());
                    intent.putExtra("gender", list.get(position).getAdp_gender());
                    intent.putExtra("age", list.get(position).getAdp_age());
                    intent.putExtra("color", list.get(position).getAdp_color());
                    intent.putExtra("kind", list.get(position).getAdp_kind());
                    intent.putExtra("weight", list.get(position).getAdp_weight());
                    intent.putExtra("shelter", list.get(position).getAdp_shelter());
                    intent.putExtra("neuter", list.get(position).getAdp_neuter());
                    intent.putExtra("content", list.get(position).getAdp_content());
                    intent.putExtra("addr", list.get(position).getAdp_addr());
                    intent.putExtra("tel", list.get(position).getAdp_tel());

                    startActivity(intent);

                }
            });


            return convertView;
        }

        public void setPic(String filename, ImageView imageView) {

            String urlStr = "http://211.63.240.26:8081/YB/AdpImageService?filename=" + filename;
            ImageLoadTask2 imageLoadTask2 = new ImageLoadTask2(urlStr, imageView);
            imageLoadTask2.execute();

        }

    }
}