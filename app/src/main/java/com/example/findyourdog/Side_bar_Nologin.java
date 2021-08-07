package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Side_bar_Nologin extends Fragment {

    private Button btn_login_go,btn_my_page_go,btn_shelter_info_go,btn_question_go;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_side_bar_nologin, container, false);

        btn_login_go = fragment.findViewById(R.id.btn_login_go);
        btn_my_page_go = fragment.findViewById(R.id.btn_my_page_go);
        btn_shelter_info_go = fragment.findViewById(R.id.btn_shelter_info_go);
        btn_question_go = fragment.findViewById(R.id.btn_question_go);

        String id = PreferenceManager.getString(getContext(),"id");
        if (id.equals(PreferenceManager.DEFAULT_STRING)){
            btn_login_go.setText("로그인");
        }else if (id != null){
            btn_login_go.setText("로그아웃");
        }


        btn_login_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_login_go.getText().equals("로그인")){
                    Intent intent = new Intent(getActivity(),Login.class);
                    startActivity(intent);
                }else if (btn_login_go.getText().equals("로그아웃")){
                    PreferenceManager.remove(getContext(),"id");
                    Intent intent = new Intent(getActivity(),Main.class);
                    startActivity(intent);
                }
            }
        });
        btn_shelter_info_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnet = new Intent(getActivity(),Side_bar_Shelter_Info.class);
                startActivity(intnet);
            }
        });
        btn_my_page_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Side_bar_MyPage.class);
                startActivity(intent);
            }
        });
        btn_question_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Question.class);
                startActivity(intent);
            }
        });


        return fragment;
    }
}