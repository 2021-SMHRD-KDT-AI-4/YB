package com.example.findyourdog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class L_Dog_Write2 extends AppCompatActivity {

  private EditText edt_l_sex, edt_l_birth, edt_l_color, edt_l_type, edt_l_kg, edt_l_feature;
  private Button btn_l_picture_plus,btn_l_enroll;
  private ImageView img_l_dog_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_dog_write2);
        Log.v("L_Write2","O");

        edt_l_sex = findViewById(R.id.edt_l_sex);
        edt_l_birth = findViewById(R.id.edt_l_birth);
        edt_l_color = findViewById(R.id.edt_l_color);
        edt_l_type =findViewById(R.id.edt_l_type);
        edt_l_kg = findViewById(R.id.edt_l_kg);
        edt_l_feature = findViewById(R.id.edt_f_feature);
        btn_l_enroll = findViewById(R.id.btn_f_enroll);
        btn_l_picture_plus = findViewById(R.id.btn_l_picture_plus);
        img_l_dog_picture = findViewById(R.id.img_l_dog_picture);

        btn_l_picture_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 500);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 500 && resultCode == RESULT_OK){
            try {
                InputStream in = getContentResolver().openInputStream(data.getData());

                Bitmap img = BitmapFactory.decodeStream(in);
                in.close();

                img_l_dog_picture.setImageBitmap(img);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(resultCode == RESULT_CANCELED){
            Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
        }
    }
}