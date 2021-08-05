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

public class L_Dog_List_copy extends Fragment {

    private ImageView img_menu, img_l_dog_1, img_l_dog_2, img_l_dog_3, img_l_dog_4;
    private TextView app_name4, tv_l_dog1, tv_l_dog2, tv_l_dog3, tv_l_dog4;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_l_dog_list_copy, container, false);

        img_menu = fragment.findViewById(R.id.img_menu);
        btn_1 = fragment.findViewById(R.id.btn_1);
        btn_2 = fragment.findViewById(R.id.btn_2);
        btn_3 = fragment.findViewById(R.id.btn_3);
        btn_4 = fragment.findViewById(R.id.btn_4);
        btn_5 = fragment.findViewById(R.id.btn_5);
        img_menu = fragment.findViewById(R.id.img_menu);
        img_l_dog_1 = fragment.findViewById(R.id.img_l_dog_1);
        img_l_dog_2 = fragment.findViewById(R.id.img_l_dog_2);
        img_l_dog_3 = fragment.findViewById(R.id.img_l_dog_3);
        img_l_dog_4 = fragment.findViewById(R.id.img_l_dog_4);
        app_name4 = fragment.findViewById(R.id.tv_appname);
        tv_l_dog1 = fragment.findViewById(R.id.tv_l_dog1);
        tv_l_dog2 = fragment.findViewById(R.id.tv_l_dog2);
        tv_l_dog3 = fragment.findViewById(R.id.tv_l_dog3);
        tv_l_dog4 = fragment.findViewById(R.id.tv_l_dog1);


        return fragment;
    }
}