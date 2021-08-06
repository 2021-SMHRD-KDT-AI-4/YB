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

public class Side_bar_Shelter_Info extends AppCompatActivity {

    private ImageView img_menu;
    private TextView tv_appname, tv_shelter_info, tv_city, tv_gungu;
    private Button btn_search;
    private Spinner spin_city, spin_gungu;

    String[] items = {"제주","강원","서울","경기","충북","충남","경북","경남",
            "전북","전남","인천","대전","대구","울산","부산","광주","세종"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar_shelter_info);

        img_menu = findViewById(R.id.img_menu);
        tv_appname = findViewById(R.id.tv_appname);
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
                tv_city.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv_city.setText("선택 : ");
            }
        });
    }
}