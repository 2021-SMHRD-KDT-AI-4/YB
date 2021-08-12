package com.example.findyourdog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class L_Dog_Write_Result extends AppCompatActivity {

    private TextView tv_l_type,tv_l_day,tv_l_place,tv_l_time,tv_l_tel;
    private ImageView l_dog_picture2;
    private ImageButton imgbtn_l_s_tel, imgbtn_l_s_info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write_result);


        l_dog_picture2 = findViewById(R.id.img_l_dog_picture2);
        imgbtn_l_s_tel =(ImageButton) findViewById(R.id.imgbtn_l_s_tel);
        imgbtn_l_s_info =(ImageButton) findViewById(R.id.imgbtn_l_s_info);
        tv_l_type =findViewById(R.id.tv_l_d_result_kind2);
        tv_l_day =findViewById(R.id.tv_l_d_result_day);
        tv_l_place =findViewById(R.id.tv_l_d_result_place);
        tv_l_time =findViewById(R.id.tv_l_d_result_time);
        tv_l_tel =findViewById(R.id.tv_l_d_result_tel);

        Intent intent = getIntent();
        tv_l_type.setText(intent.getStringExtra("l_type"));
        tv_l_day.setText(intent.getStringExtra("l_day"));
        tv_l_place.setText(intent.getStringExtra("l_place"));
        tv_l_time.setText(intent.getStringExtra("l_time"));
        tv_l_tel.setText(intent.getStringExtra("l_tel"));
        Bitmap imgbit = intent.getParcelableExtra("imgbit");
        l_dog_picture2.setImageBitmap(imgbit);

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