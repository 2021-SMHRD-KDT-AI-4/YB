package com.example.findyourdog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Dog_Info extends Fragment {
    //
    private ImageView img_menu, img_profile;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_dog_print, btn_profile_ok;
    private TextView tv_appname, tv_profile, tv_info_add, tv_info_color, tv_info_name;
    private TextView tv_info_sex, tv_info_type, tv_info_dogprint;
    private EditText edt_info_add, edt_info_sex, edt_info_type, edt_info_name, edt_info_color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_dog_info, container, false);


        img_menu = fragment.findViewById(R.id.img_menu);
        btn_1 = fragment.findViewById(R.id.btn_1);
        btn_2 = fragment.findViewById(R.id.btn_2);
        btn_3 = fragment.findViewById(R.id.btn_3);
        btn_4 = fragment.findViewById(R.id.btn_4);
        btn_5 = fragment.findViewById(R.id.btn_5);
        btn_dog_print = fragment.findViewById(R.id.btn_dog_print);
        btn_profile_ok = fragment.findViewById(R.id.btn_profile_ok);
        tv_appname = fragment.findViewById(R.id.tv_appname);
        img_profile = fragment.findViewById(R.id.img_profile);
        tv_profile = fragment.findViewById(R.id.tv_profile);
        tv_info_add = fragment.findViewById(R.id.tv_info_add);
        tv_info_color = fragment.findViewById(R.id.tv_info_color);
        tv_info_name = fragment.findViewById(R.id.tv_info_name);
        tv_info_sex = fragment.findViewById(R.id.tv_info_sex);
        tv_info_type = fragment.findViewById(R.id.tv_info_type);
        tv_info_dogprint = fragment.findViewById(R.id.tv_info_dogprint);
        edt_info_add = fragment.findViewById(R.id.edt_info_add);
        edt_info_sex = fragment.findViewById(R.id.edt_info_sex);
        edt_info_type = fragment.findViewById(R.id.edt_info_type);
        edt_info_name = fragment.findViewById(R.id.edt_info_name);
        edt_info_color = fragment.findViewById(R.id.edt_info_color);
        return fragment;
    }
}