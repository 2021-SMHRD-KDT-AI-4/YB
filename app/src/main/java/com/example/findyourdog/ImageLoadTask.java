package com.example.findyourdog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> { // 보낼 타입, 받아올 타입

    private String urlStr;  // 서버의 주소를 저장할 변수
    private ImageView imageView;  // 이미지를 보여줄 이미지뷰
    private static HashMap<String, Bitmap> bitmapHashMap = new HashMap<String,Bitmap>(); // 이미지를 받아서 변환해줄 객체

    public ImageLoadTask(String urlStr, ImageView imageView) {
        this.urlStr = urlStr;
        this.imageView = imageView;
    }

    // doInBackground가 실행됐을 때 실행되는 메소드
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        // 메인에서 받아온 이미지뷰에 bitmap 이미지 넣어줌
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        imageView.invalidate();
    }

    // 추상메소드 doInBackground 구현
    // 가장 먼저 실행되는 메소드
    @Override
    protected Bitmap doInBackground(Void... voids) {

        Bitmap bitmap = null;
        if(bitmapHashMap.containsKey(urlStr)) {
            Bitmap oldbitmap = bitmapHashMap.remove(urlStr); // 이전에 있던 bitmap에 담겨있는 것을 지워준다
            if(oldbitmap != null){
                oldbitmap.recycle();
                oldbitmap = null;
            }
        }
        try {
            URL url = new URL(urlStr);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            bitmapHashMap.put(urlStr, bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

}