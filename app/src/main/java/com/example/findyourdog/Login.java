package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText login_id, login_pw;
    private TextView app_name, tv_login, tv_id, tv_pw;
    private Button login_login, login_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_id = findViewById(R.id.login_id);
        login_pw = findViewById(R.id.login_pw);
        app_name = findViewById(R.id.app_name);
        tv_login = findViewById(R.id.tv_login);
        tv_id = findViewById(R.id.tv_id);
        tv_pw = findViewById(R.id.tv_pw);
        login_login = findViewById(R.id.login_login);
        login_join = findViewById(R.id.login_join);

        login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), F_Dog_List.class);
                startActivity(intent);
            }

        });

        login_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.projectyb.Join.class);
                startActivity(intent);
            }
        });
    }
}