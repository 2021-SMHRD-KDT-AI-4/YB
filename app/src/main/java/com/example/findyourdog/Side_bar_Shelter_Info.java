package com.example.findyourdog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.HashSet;
import java.util.Map;

public class Side_bar_Shelter_Info extends AppCompatActivity {

    private TextView tv_shelter_info, tv_city, tv_gungu;
    private Button btn_search;
    private Spinner spin_city, spin_gungu;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private ShelterAdapter shelterAdapter;
    private ListView listView;


    public ArrayList<String[]> shelter_list = new ArrayList<String[]>();

    String[] items = {"제주","강원","서울","경기","충북","충남","경북","경남",
            "전북","전남","인천","대전","대구","울산","부산","광주","세종"};

    String[] jeju = {"제주시", "서귀포시"};

    String[] gangwon = {"춘천시","원주시","강릉시","동해시","태백시","속초시","삼척시","홍천군","횡성군",
            "영월군","평창군","정선군","철원군","화천군","양구군","인제군","고성군","양양군"};

    String[] seoul = {"종로구","중구","용산구","성동구","광진구","동대문구","중랑구","성북구","강북구",
            "도봉구","노원구","은평구","서대문구","마포구","양천구","강서구","구로구","금천구","영등포구",
            "동작구","관악구","서초구","강남구","송파구","강동구"};

    String[] gyeonggi = {"수원시","성남시","의정부시","안양시","부천시","광명시","평택시","동두천시",
            "안산시","고양시","과천시","구리시","남양주시","오산시","시흥시","군포시","의왕시","하남시","용인시",
            "파주시","이천시","안성시","김포시","화성시","광주시","양주시","포천시","여주시","연천군","가평군","양평군"};

    String[] chungbuk = {"청주시","충주시","제천시","보은군","옥천군","영동군","증평군","진천군",
            "괴산군","음성군","단양군"};

    String[] chungnam = {"천안시","공주시","보령시","아산시","서산시","논산시","계룡시","당진시",
            "금산군","부여군","서천군","청양군","홍성군","예산군","태안군"};

    String[] gyeongbuk = {"포항시","경주시","김천시","안동시","구미시","영주시","영천시","상주시","문경시",
            "경산시","군위군","의성군","청송군","영양군","영덕군","청도군","고령군",
            "성주군","칠곡군","예천군","봉화군","울진군","울릉군"};

    String[] gyeongnam = {"창원시","진주시","통영시","사천시","김해시","밀양시","거제시","양산시",
            "의령군","함안군","창녕군","고성군","남해군","하동군","산청군","함양군","거창군","합천군"};

    String[] jeonbuk = {"전주시","군산시","익산시","정읍시","남원시","김제시","완주군","진안군",
            "무주군","장수군","임실군","순창군","고창군","부안군"};

    String[] jeonnam = {"목표시","여수시","순천시","나주시","광양시","담양군","곡성군","구례군","고흥군",
            "보성군","화순군","장흥군","강진군","해남군","영암군","무안군","함평군","영광군","장성군","완도군","진도군","신안군"};

    String[] incheon = {"중구","동구","미추홀구","연수구","남동구","부평구","계양구","서구","강화군","옹진군"};

    String[] daejeon = {"동구","중구","서구","유성구","대덕구"};

    String[] daegu = {"동구","중구","서구","남구","북구","수성구","달서구","달성군"};

    String[] ulsan = {"동구","중구","남구","북구","울주군"};

    String[] busan = {"동구","중구","서구","남구","북구","영도구","부산진구","동래구","해운대구","사하구","금정구",
            "강서구","연제구","수영구","사상구","기장군"};

    String[] gwangju = {"동구","서구","남구","북구","광산구"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar_shelter_info);

        listView = findViewById(R.id.shelter_listview);
        shelterAdapter = new ShelterAdapter();



        tv_shelter_info = findViewById(R.id.tv_shelter_info);
        tv_city = findViewById(R.id.tv_city);
        tv_gungu = findViewById(R.id.tv_gungu);
        btn_search = findViewById(R.id.btn_search);
        spin_city = findViewById(R.id.spin_city);
        spin_gungu = findViewById(R.id.spin_gungu);

        Spinner spinner = (Spinner) findViewById(R.id.spin_city);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );

        // 드롭다운 클릭 시 선택 창
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spin_city.setAdapter(adapter);
        // 스피너에서 선택 했을 경우 이벤트 처리

        spin_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String value = (String)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                ArrayAdapter<String> gunguAdapter = null;

                if(value.equals("제주")){
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, jeju
                    );
                }else if (value.equals("강원")){
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, gangwon
                    );
                }else if(value.equals("서울")){
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, seoul
                    );
                }else if(value.equals("경기")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, gyeonggi
                    );
                }else if(value.equals("충북")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, chungbuk
                    );
                }else if(value.equals("충남")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, chungnam
                    );
                }else if(value.equals("경북")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, gyeongbuk
                    );
                }else if(value.equals("경남")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, gyeongnam
                    );
                }else if(value.equals("전북")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, jeonbuk
                    );
                }else if(value.equals("전남")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, jeonnam
                    );
                }else if(value.equals("인천")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, incheon
                    );
                }else if(value.equals("대전")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, daejeon
                    );
                }else if(value.equals("대구")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, daegu
                    );
                }else if(value.equals("울산")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, ulsan
                    );
                }else if(value.equals("부산")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, busan
                    );
                }else if(value.equals("광주")) {
                    gunguAdapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_spinner_item, gwangju
                    );
                }
                spin_gungu.setAdapter(gunguAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //tv_city.setText("선택 : ");
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = getIntent();
//                finish(); //현재 액티비티 종료 실시
//                overridePendingTransition(0, 0); //인텐트 애니메이션 없애기
//                startActivity(intent); //현재 액티비티 재실행 실시
//                overridePendingTransition(0, 0); //인텐트 애니메이션 없애기


//                shelterAdapter.clear();
//                shelterAdapter.notifyDataSetChanged();
                showRequest();


            }
        });


    }
    public void showRequest() {
        // Voolley Lib 새료운 요청객체 생성
        queue = Volley.newRequestQueue(getApplicationContext());
        //211.63.240.26 연지
        //211.227.224.206 창현
        String url = "http://211.63.240.26:8081/YB/ShelterInfoService";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("보호소", response);
                shelterAdapter.clear();
                shelterAdapter.notifyDataSetChanged();
                shelter_list.clear();
                try {
                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String shelter_name = jsonObject.getString("shelter_name");
                        String shelter_addr = jsonObject.getString("shelter_addr");

                        Log.v("보호소정보확인", "보호소이름 : " + shelter_name + "보호소주소 : " + shelter_addr);


                        String[] list = {shelter_name, shelter_addr};
                        shelter_list.add(list);

                    }



                    for (int i = 0; i < shelter_list.size(); i++) {
                        shelterAdapter.addItem(new ShelterItem(shelter_list.get(i)[0], shelter_list.get(i)[1]));
                        Log.v("무야~호", shelter_list.get(i)[0] + shelter_list.get(i)[1]);

                    }
                    shelterAdapter.notifyDataSetChanged();
                    listView.setAdapter(shelterAdapter);





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


                String sido = spin_city.getSelectedItem().toString();
                String gungu = spin_gungu.getSelectedItem().toString();

                params.put("sido",sido);
                params.put("gungu",gungu);
                Log.v("resultValue", "sido : " + sido);
                Log.v("resultValue", "gungu : " + gungu);


                return params;
            }
        };


        queue.add(stringRequest);
    }
    public class ShelterAdapter extends BaseAdapter {
        ArrayList<ShelterItem> items = new ArrayList<ShelterItem>();
        @Override
        public int getCount() { return items.size(); }

        @Override
        public Object getItem(int position) { return items.get(position); }
        @Override
        public long getItemId(int position) { return 0; }

        public void removeItem(ShelterItem item){items.remove(item);}

        public void clear( ){
            items.clear();
        }


        public void addItem(ShelterItem item) { items.add(item); }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Context context = parent.getContext();
            ShelterItem shelterItem = items.get(position);

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.shelter_listview,parent,false);
            }

            TextView tv_shelter_name = convertView.findViewById(R.id.tv_shelter_name);
            TextView tv_shelter_addr = convertView.findViewById(R.id.tv_shelter_addr);


            tv_shelter_name.setText(shelterItem.getShelter_name());
            tv_shelter_addr.setText(shelterItem.getShelter_addr());
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