package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
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

    private Button btn_1, btn_2, btn_3, btn_4, btn_5;
    private TextView app_name2, main_type1, main_type2, main_type3, main_type4;
    private ImageView main_img1, main_img2, main_img3, main_img4;
    private ImageButton imgbtn_write;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_f_dog_list_copy, container, false);







        imgbtn_write = fragment.findViewById(R.id.imgbtn_write);



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