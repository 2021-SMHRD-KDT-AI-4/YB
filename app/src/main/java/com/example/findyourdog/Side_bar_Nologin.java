package com.example.findyourdog;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Side_bar_Nologin extends Fragment {

    private ImageView img_menu;
    private TextView app_name, tv_mypage, tv_mypage_dog_nose;
    private TextView tv_mypage_dog_name, tv_mypage_ok;
    private Button btn_mypage_plus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_side_bar_nologin, container, false);

        img_menu = fragment.findViewById(R.id.img_menu);
        app_name = fragment.findViewById(R.id.app_name);
        tv_mypage = fragment.findViewById(R.id.tv_mypage);
        tv_mypage_dog_nose = fragment.findViewById(R.id.tv_mypage_dog_nose);
        tv_mypage_dog_name = fragment.findViewById(R.id.tv_mypage_dog_name);
        tv_mypage_ok = fragment.findViewById(R.id.tv_mypage_ok);
        btn_mypage_plus = fragment.findViewById(R.id.btn_mypage_plus);

        return fragment;
    }
}