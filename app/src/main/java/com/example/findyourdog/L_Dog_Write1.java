package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Write1 extends AppCompatActivity {

  private EditText edt_l_day, edt_l_time,edt_l_tel,edt_l_place;
  private Button btn_l_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write1);

        edt_l_day = findViewById(R.id.edt_l_day);
        edt_l_place = findViewById(R.id.edt_l_place);
        edt_l_time = findViewById(R.id.edt_l_time);
        edt_l_tel =findViewById(R.id.edt_l_tel);
        btn_l_next = findViewById(R.id.btn_l_next);

        btn_l_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),L_Dog_Write2.class);
                startActivity(intent);
            }
        });

    }
}