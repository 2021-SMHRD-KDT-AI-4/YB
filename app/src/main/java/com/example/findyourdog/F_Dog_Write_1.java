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

    private TextView tv_f_day,tv_f_time,tv_f_picture,tv_f_tel,tv_f_place,tv_star6,
            tv_star7, tv_star8, tv_star9, tv_star10;
    private Button btn_f_picture_plus, btn_f_next, btn_f_camera;
    private EditText edt_f_day, edt_f_tel, edt_f_place, edt_f_time;
    private ImageView img_f_picture;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_dog_write_1);


        edt_f_tel = findViewById(R.id.edt_f_tel);
        edt_f_time = findViewById(R.id.edt_f_time);
        edt_f_place = findViewById(R.id.edt_f_place);
        edt_f_day = findViewById(R.id.edt_f_day);
        btn_f_next = findViewById(R.id.btn_f_next);
        img_f_picture = findViewById(R.id.img_f_picture);
        btn_f_picture_plus = findViewById(R.id.btn_f_picture_plus);
        btn_f_camera = findViewById(R.id.btn_f_camera);

        btn_f_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),F_Dog_Write_2.class);
                startActivity(intent);
            }
        });

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