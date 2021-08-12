package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Question extends AppCompatActivity {


    static final String[] LIST_MENU = {"Q. 유기견을 발견하면 어떻게 해야 하나요?", "Q. 보호소 연결이 안 될 경우엔 어떡하죠?", "Q. 유기견 입양하고 싶은데 절차가 어떻게 되나요?",
            "Q. 비문 등록 잘하는 방법이 궁금해요 !","Q. 비문 등록을 여러개 해놓아도 되나요?"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
//        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, LIST_MENU);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU) ;

        ListView listview = (ListView) findViewById(R.id.listview1) ;
        listview.setAdapter(adapter) ;

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 코드 계속 ...

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get TextView's Text.
                String strText = (String) parent.getItemAtPosition(position) ;
                Log.v("test", strText.toString());
                Intent intent = new Intent(getApplicationContext(), Question_Result.class);
                intent.putExtra("title", strText);
                startActivity(intent);
            }
        }) ;

//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String strText = (String) parent.getItemAtPosition(position);
//                Log.v("test", strText.toString());
//                Intent intent = new Intent(getApplicationContext(), Question_Result.class);
//                intent.putExtra("title", strText);
//
//                startActivity(intent);
//            }
//        });


    }
}