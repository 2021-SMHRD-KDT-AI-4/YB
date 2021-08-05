package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.findyourdog.databinding.ActivitySidebarBinding;

public class Sidebar extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivitySidebarBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String id = PreferenceManager.getString(getApplicationContext(),"id");

        binding = ActivitySidebarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarSidebar.toolbar);

        binding.appBarSidebar.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sidebar);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        View headView = navigationView.getHeaderView(0);
        Button btn_nav_login = headView.findViewById(R.id.btn_nav_login);
        Button btn_nav_logout = headView.findViewById(R.id.btn_nav_logout);

        ImageView img = headView.findViewById(R.id.imageView);
        Log.v("info",id.toString());
        if(id.equals("데이터가 없습니다")) {
            img.setImageResource(R.drawable.one);
            btn_nav_logout.setEnabled(false);
        }
        else if(id.length() > 0){
            img.setImageResource(R.drawable.three);
            btn_nav_login.setEnabled(false);
        }


        btn_nav_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
        btn_nav_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.remove(getApplicationContext(),"id");
                Intent intent = new Intent(getApplicationContext(),Sidebar.class);
                startActivity(intent);
            }
        });







    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sidebar, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sidebar);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}