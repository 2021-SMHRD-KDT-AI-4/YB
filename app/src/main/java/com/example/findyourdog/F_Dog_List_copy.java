package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.findyourdog.databinding.ActivityFDogListCopyBinding;
import com.example.findyourdog.databinding.ActivityLoginBinding;

public class F_Dog_List_copy extends Fragment {


    private TextView tv_page1, tv_page2, tv_page3, tv_page4, tv_page5;
    private ImageButton imgbtn_write;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_f_dog_list_copy, container, false);

        tv_page1 = fragment.findViewById(R.id.tv_page1);
        tv_page2 = fragment.findViewById(R.id.tv_page2);
        tv_page3 = fragment.findViewById(R.id.tv_page3);
        tv_page4 = fragment.findViewById(R.id.tv_page4);
        tv_page5 = fragment.findViewById(R.id.tv_page5);

        imgbtn_write = (ImageButton) fragment.findViewById(R.id.imgbtn_write);

//        app_name2 = fragment.findViewById(R.id.app_name2);
//        main_type1 = fragment.findViewById(R.id.main_type1);
//        main_type2 = fragment.findViewById(R.id.main_type2);
//        main_type3 = fragment.findViewById(R.id.main_type3);
//        main_type4 = fragment.findViewById(R.id.main_type4);
//        main_img1 = fragment.findViewById(R.id.main_img1);
//        main_img2 = fragment.findViewById(R.id.main_img2);
//        main_img3 = fragment.findViewById(R.id.main_img3);
//        main_img4 = fragment.findViewById(R.id.main_img4);

        imgbtn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),F_Dog_Write_1.class);
                startActivity(intent);
            }
        });
        return fragment;
    }

}