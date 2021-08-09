package com.example.findyourdog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class P_Dog_list extends Fragment {

    private TextView tv_page15,tv_page16,tv_page17,tv_page18,tv_page19;
    private ImageButton imgbtn_a_write;
    private GridView gv_adopt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_p_dog_list, container, false);


        gv_adopt = fragment.findViewById(R.id.gv_adopt);




        return fragment;
    }
}