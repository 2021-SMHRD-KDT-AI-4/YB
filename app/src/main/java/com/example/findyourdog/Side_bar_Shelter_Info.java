package com.example.findyourdog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Side_bar_Shelter_Info extends AppCompatActivity {

    private TextView tv_shelter_info, tv_city, tv_gungu;
    private Button btn_search;
    private Spinner spin_city, spin_gungu;

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


    }
}