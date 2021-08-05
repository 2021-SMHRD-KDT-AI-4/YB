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

public class P_Dog_list extends Fragment {

    private ImageView img_menu, img_p_dog1, img_p_dog2, img_p_dog3, img_p_dog4;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView tv_appname, tv_p_dog1, tv_p_dog2, tv_p_dog3, tv_p_dog4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_p_dog_list, container, false);

        img_menu = fragment.findViewById(R.id.img_menu);
        btn_1 = fragment.findViewById(R.id.btn_1);
        btn_2 = fragment.findViewById(R.id.btn_2);
        btn_3 = fragment.findViewById(R.id.btn_3);
        btn_4 = fragment.findViewById(R.id.btn_4);
        btn_5 = fragment.findViewById(R.id.btn_5);
        img_p_dog1 = fragment.findViewById(R.id.img_p_dog1);
        img_p_dog2 = fragment.findViewById(R.id.img_p_dog2);
        img_p_dog3 = fragment.findViewById(R.id.img_p_dog3);
        img_p_dog4 = fragment.findViewById(R.id.img_p_dog4);
        tv_appname = fragment.findViewById(R.id.tv_appname);
        tv_p_dog1 = fragment.findViewById(R.id.tv_p_dog1);
        tv_p_dog2 = fragment.findViewById(R.id.tv_p_dog2);
        tv_p_dog3 = fragment.findViewById(R.id.tv_p_dog3);
        tv_p_dog4 = fragment.findViewById(R.id.tv_p_dog4);

        return fragment;
    }
}