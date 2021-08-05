package com.example.findyourdog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class Home extends AppCompatActivity {
    Fragment f_dog_list_copy, l_dog_list_copy, picture_or_dog_print,dog_info,p_dog_list;
    private BottomNavigationView bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        f_dog_list_copy = new F_Dog_List_copy();
        l_dog_list_copy = new L_Dog_List_copy();
        picture_or_dog_print = new Picture_or_Dog_Print();
        dog_info = new Dog_Info();
        p_dog_list = new P_Dog_list();

        bottom = findViewById(R.id.bottom);


        getSupportFragmentManager().beginTransaction().replace(R.id.frame, l_dog_list_copy).commit();
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                if(item.getItemId() == R.id.page1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f_dog_list_copy).commit();
                }else if (item.getItemId()== R.id.page2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,l_dog_list_copy).commit();
                }else if (item.getItemId()== R.id.page3){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,dog_info).commit();
               }else if (item.getItemId()== R.id.page4){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,picture_or_dog_print).commit();
                }else if (item.getItemId()== R.id.page5){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,p_dog_list).commit();
                }
                return true;
            }
        });
    }
}