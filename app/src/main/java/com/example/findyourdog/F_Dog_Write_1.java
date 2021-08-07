package com.example.findyourdog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class F_Dog_Write_1 extends AppCompatActivity {

    private TextView app_name4, tv_info, tv_tel, tv_date, tv_where, tv_img, tv_time;
    private TextView tv_star6, tv_star7, tv_star8, tv_star9, tv_star10;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_f_picture_plus, btn_ok, btn_f_camera;
    private EditText edt_find, edt_tel, edt_where, edt_time;
    private ImageView img_f_picture;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_1);

        app_name4 = findViewById(R.id.tv_appname);
        tv_info = findViewById(R.id.tv_info);
        tv_tel = findViewById(R.id.tv_tel);
        tv_date = findViewById(R.id.tv_l_date);
        tv_where = findViewById(R.id.tv_where);
        tv_img = findViewById(R.id.tv_img);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_f_picture_plus = findViewById(R.id.btn_f_picture_plus);
        btn_ok = findViewById(R.id.btn_f_next);
        edt_find = findViewById(R.id.edt_find);
        edt_tel = findViewById(R.id.edt_place);
        edt_where = findViewById(R.id.edt_time);
        tv_time = findViewById(R.id.tv_l_time);
        edt_time = findViewById(R.id.edt_time);
        tv_star6 = findViewById(R.id.tv_star6);
        tv_star7 = findViewById(R.id.tv_star7);
        tv_star8 = findViewById(R.id.tv_star8);
        tv_star9 = findViewById(R.id.tv_star9);
        tv_star10 = findViewById(R.id.tv_star10);
        img_f_picture = findViewById(R.id.img_f_picture);
        btn_f_camera = findViewById(R.id.btn_f_camera);

        btn_f_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1111);
            }

        });

        btn_f_picture_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1000);
            }
        });


    }

    public void takePicture() {
        if (file == null) {
            file = createfile();
        }
    }

    private File createfile() {
        String filename = "capture.jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File outFile = new File(storageDir,filename);


        return outFile;
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    img_f_picture.setImageBitmap(img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
        } else if(requestCode == 1111 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img_f_picture.setImageBitmap(imageBitmap);
        }

    }
}