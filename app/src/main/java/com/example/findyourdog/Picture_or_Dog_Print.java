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

public class Picture_or_Dog_Print extends Fragment {

    private Button btn_nose_print_result_go, btn_picture_result_go;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_picture_or_dog_print, container, false);

        btn_nose_print_result_go = fragment.findViewById(R.id.btn_nose_print_result_go);
        btn_picture_result_go = fragment.findViewById(R.id.btn_picture_result_go);

        btn_picture_result_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Picture_Choice.class);
                startActivity(intent);
            }
        });
        btn_nose_print_result_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Dog_Nose_Print_Choice.class);
                startActivity(intent);
            }
        });

        return fragment;

    }
}