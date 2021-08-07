package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dog_Nose_Print_Choice extends AppCompatActivity {

    private ImageView img_menu, img_nose1, img_nose2;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_want_find;
    private TextView tv_appname, tv_dog_nose_print_choice, tv_img1_name, tv_img2_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_nose_print_choice);

        btn_want_find = findViewById(R.id.btn_want_find);

        btn_want_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Dog_Nose_print_Search_list_Success.class);
                startActivity(intent);

            }
        });


    }
}