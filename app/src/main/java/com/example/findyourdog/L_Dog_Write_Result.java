package com.example.findyourdog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Write_Result extends AppCompatActivity {

    private TextView tv_s_tel, tv_s_info,tv_l_dog_detail,tv_l_dog_shelter_alarm,tv_l_dog_alarm2;
    private ImageView img_l_dog_picture2;
    private ImageButton imgbtn_l_s_tel, imgbtn_l_s_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write_result);

        img_l_dog_picture2 = findViewById(R.id.img_l_dog_picture2);
        imgbtn_l_s_tel =(ImageButton) findViewById(R.id.imgbtn_l_s_tel);
        imgbtn_l_s_info =(ImageButton) findViewById(R.id.imgbtn_l_s_info);


        imgbtn_l_s_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calling(v);
//                Intent intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse("tel:01012341234"));
//                try {
//                    startActivity(intent);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }

            }
        });

        imgbtn_l_s_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    void showDialog(){
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(L_Dog_Write_Result.this)

                .setTitle("보호소 위치")
                .setMessage("")
                .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();


    }


    public void calling(View view){
        Log.v("callresult","gogo");
        Uri uri = Uri.parse("tel:010010101");
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
//        Intent intent = new Intent((Intent.ACTION_CALL));
//        intent.setData(Uri.parse("tel:01062159216"));
//        try {
//            startActivity(intent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }



    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_dog_nose_print_reg:
                new AlertDialog.Builder(this)
                        .setTitle("보호소 위치")
                        .setMessage("등록이 완료되었습니다!")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                break;
    }

    }

}