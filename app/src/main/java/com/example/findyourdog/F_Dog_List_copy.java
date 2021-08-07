package com.example.findyourdog;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.findyourdog.databinding.ActivityFDogListCopyBinding;
import com.example.findyourdog.databinding.ActivityLoginBinding;

public class F_Dog_List_copy extends Fragment implements View.OnClickListener {

    private TextView tv_page1, tv_page2, tv_page3, tv_page4, tv_page5;
    private GridView gv_find;
    private ImageButton imgbtn_f_write;
    private Context pageContext;

    public F_Dog_List_copy(Context pageContext) {
        this.pageContext = pageContext;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_f_dog_list_copy, container, false);
        tv_page1 = fragment.findViewById(R.id.tv_page1);
        tv_page2 = fragment.findViewById(R.id.tv_page2);
        tv_page3 = fragment.findViewById(R.id.tv_page3);
        tv_page4 = fragment.findViewById(R.id.tv_page4);
        tv_page5 = fragment.findViewById(R.id.tv_page5);
        gv_find = fragment.findViewById(R.id.gv_find);
        imgbtn_f_write = fragment.findViewById(R.id.imgbtn_f_write);

        imgbtn_f_write.setOnClickListener(this);
        return  fragment;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), F_Dog_Write_1.class);
        startActivity(intent);
    }
}