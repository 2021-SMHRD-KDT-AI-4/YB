package com.example.findyourdog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class Main extends AppCompatActivity {
    Fragment f_dog_list_copy, l_dog_list_copy, picture_or_dog_print,dog_info,p_dog_list,side_bar_nologin;
//    private BottomNavigationView bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        f_dog_list_copy = new F_Dog_List_copy();
        l_dog_list_copy = new L_Dog_List_copy();
        picture_or_dog_print = new Picture_or_Dog_Print();
        dog_info = new Dog_Info();
        p_dog_list = new P_Dog_list();
        side_bar_nologin = new Side_bar_Nologin();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,f_dog_list_copy).commit();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){
                    selected = f_dog_list_copy;
                }else if (position==1){
                    selected = l_dog_list_copy;
                }else if (position ==2){
                    selected = picture_or_dog_print;
                }else if (position ==3){
                    selected = dog_info;
                }else if (position ==4){
                    selected = p_dog_list;
                }else if (position ==5){
                    selected = side_bar_nologin;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



//        bottom = findViewById(R.id.bottom);
//
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame, f_dog_list_copy).commit();
//        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
//
//                if(item.getItemId() == R.id.page1){
//                    //Toast.makeText(getApplicationContext(),"눌렀음",Toast.LENGTH_SHORT).show();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f_dog_list_copy).commit();
//                }else if (item.getItemId()== R.id.page2){
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,l_dog_list_copy).commit();
//                }else if (item.getItemId()== R.id.page3){
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame,dog_info).commit();
//               }else if (item.getItemId()== R.id.page4){
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,picture_or_dog_print).commit();
//                }else if (item.getItemId()== R.id.page5){
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,p_dog_list).commit();
//                }
//                return true;
//            }
//        });
    }
}