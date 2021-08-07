package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class L_Dog_List_copy extends Fragment {

    private TextView tv_page6,tv_page7,tv_page8,tv_page9,tv_page10;
    private ImageButton imgbtn_l_write;
    private GridView gv_lost;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_l_dog_list_copy, container, false);

        tv_page6 = fragment.findViewById(R.id.tv_page6);
        tv_page7 = fragment.findViewById(R.id.tv_page7);
        tv_page8 = fragment.findViewById(R.id.tv_page8);
        tv_page9 = fragment.findViewById(R.id.tv_page9);
        tv_page10 = fragment.findViewById(R.id.tv_page10);
        gv_lost = fragment.findViewById(R.id.gv_find);

        imgbtn_l_write = (ImageButton) fragment.findViewById(R.id.imgbtn_l_write);


        imgbtn_l_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("cc","click");
                Intent intent = new Intent(getActivity(), L_Dog_Write1.class);
                startActivity(intent);
            }
        });

        return fragment;
    }

}