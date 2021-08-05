package com.example.findyourdog;

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

    private ImageView img_menu;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView app_name4, tv_nose_result_go, tv_picture_result_go;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_picture_or_dog_print, container, false);

        img_menu = fragment.findViewById(R.id.img_menu);
        btn_1 = fragment.findViewById(R.id.btn_1);
        btn_2 = fragment.findViewById(R.id.btn_2);
        btn_3 = fragment.findViewById(R.id.btn_3);
        btn_4 = fragment.findViewById(R.id.btn_4);
        btn_5 = fragment.findViewById(R.id.btn_5);
        app_name4 = fragment.findViewById(R.id.tv_appname);
        tv_nose_result_go = fragment.findViewById(R.id.tv_nose_result_go);
        tv_picture_result_go = fragment.findViewById(R.id.tv_picture_result_go);

        return fragment;

    }
}