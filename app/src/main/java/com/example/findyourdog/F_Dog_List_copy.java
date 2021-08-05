package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.findyourdog.databinding.ActivityFDogListCopyBinding;
import com.example.findyourdog.databinding.ActivityLoginBinding;

public class F_Dog_List_copy extends Fragment {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_write;
    private TextView app_name2, main_type1, main_type2, main_type3, main_type4;
    private ImageView main_img1, main_img2, main_img3, main_img4;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_f_dog_list_copy, container, false);




        btn_1 = fragment.findViewById(R.id.btn_1);
        btn_2 = fragment.findViewById(R.id.btn_2);
        btn_3 = fragment.findViewById(R.id.btn_3);
        btn_4 = fragment.findViewById(R.id.btn_4);
        btn_5 = fragment.findViewById(R.id.btn_5);
        app_name2 = fragment.findViewById(R.id.app_name2);
        main_type1 = fragment.findViewById(R.id.main_type1);
        main_type2 = fragment.findViewById(R.id.main_type2);
        main_type3 = fragment.findViewById(R.id.main_type3);
        main_type4 = fragment.findViewById(R.id.main_type4);
        main_img1 = fragment.findViewById(R.id.main_img1);
        main_img2 = fragment.findViewById(R.id.main_img2);
        main_img3 = fragment.findViewById(R.id.main_img3);
        main_img4 = fragment.findViewById(R.id.main_img4);

        btn_write = fragment.findViewById(R.id.btn_write);



        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),F_Dog_Write_1.class);
                startActivity(intent);
            }
        });

        return fragment;
    }

}