package com.example.findyourdog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class L_Dog_Write1 extends AppCompatActivity {

  private EditText edt_l_day, edt_l_time,edt_l_tel,edt_l_place;
  private Button btn_l_next;

  private Spinner spn_l_sido;
  Calendar myCalendar = Calendar.getInstance();

  String[] items = new String[]{"시/도","서울","부산","대구","인천","광주","세종","대전","울산",
            "경기","강원","충남","충북","전남","전북","경남","경북","제주"};


    // 날짜 구하는 거거
    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write1);

        edt_l_day = findViewById(R.id.edt_l_day);
        edt_l_place = findViewById(R.id.edt_l_place);
        edt_l_time = findViewById(R.id.edt_l_time);
        edt_l_tel =findViewById(R.id.edt_l_tel);
        btn_l_next = findViewById(R.id.btn_l_enroll);
        spn_l_sido = findViewById(R.id.spnl_sido);

        Spinner spinner = (Spinner) findViewById(R.id.spnl_sido);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );

        // 드롭다운 클릭 시 선택 창
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);
        // 스피너에서 선택 했을 경우 이벤트 처리


        btn_l_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),L_Dog_Write2.class);

                intent.putExtra("l_day",edt_l_day.getText().toString());
                intent.putExtra("l_place",edt_l_place.getText().toString());
                intent.putExtra("l_time",edt_l_time.getText().toString());
                intent.putExtra("l_tel",edt_l_tel.getText().toString());
                Log.v("info",edt_l_day.getText().toString());
                String l_city = spinner.getSelectedItem().toString();
                int cityNum = Arrays.asList(items).indexOf(l_city);
                intent.putExtra("cityNum",cityNum+"");
                intent.putExtra("l_city",l_city);

                startActivity(intent);
            }
        });
        // 버튼 누르면 날짜 켈린더 나오고 확인하면 날짜 생성
        edt_l_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(L_Dog_Write1.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // 시간 선택 다이얼로 넘어감감
        edt_l_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(L_Dog_Write1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "AM";
                        // 선택한 시간이 12를 넘을경우 "PM"으로 변경 및 -12시간하여 출력 (ex : PM 6시 30분)
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            state = "PM";
                        }
                        // EditText에 출력할 형식 지정
                        edt_l_time.setText(state + " " + selectedHour + "시 " + selectedMinute + "분");
                    }
                }, hour, minute,  true); // true의 경우 24시간 형식의 TimePicker 출현
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

    }
    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.edt_l_day);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }
}