package com.example.findyourdog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;

public class Dog_Info extends Fragment {
    private ImageView img_nose_print;
    private Button btn_nose_print_picture_plus,btn_nose_print_camera,btn_profile_ok;
    private EditText edt_info_name,edt_info_type;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private Spinner sp_i_gender, sp_i_kind;

    public String id = "";
    private TextView edt_info_sex;

    ExifInterface exif = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.activity_dog_info, container, false);

        img_nose_print = fragment.findViewById(R.id.img_nose_print);
        btn_nose_print_picture_plus = fragment.findViewById(R.id.btn_nose_print_picture_plus);
        btn_nose_print_camera = fragment.findViewById(R.id.btn_nose_print_camera);
        btn_profile_ok = fragment.findViewById(R.id.btn_profile_ok);
        edt_info_name = fragment.findViewById(R.id.edt_info_name);
//        edt_info_sex = fragment.findViewById(R.id.edt_info_sex);
//        edt_info_type = fragment.findViewById(R.id.edt_info_type);
        sp_i_gender = fragment.findViewById(R.id.sp_i_gender);
        sp_i_kind = fragment.findViewById(R.id.sp_i_kind);

        genderspinner();
        kindspinner();

        btn_nose_print_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1001);
            }

        });
        btn_nose_print_picture_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1003);
            }
        });
        btn_profile_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { sendRequest(); }
        });

        return fragment;
    }
    private void genderspinner( ){
        String[] gender_items = new String[]{
                "??????","??????"
        };
        ArrayAdapter <String> genderAdapter = new ArrayAdapter<String>(
                getActivity(),R.layout.support_simple_spinner_dropdown_item,gender_items);
        genderAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_i_gender.setAdapter(genderAdapter);
        sp_i_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                edt_info_sex.setText(gender_items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void kindspinner( ){
        String[] dogkind = new String[]{
                "??????","?????? ????????????","????????????","?????????","?????????","?????? ??????","??????","??????",
                "??????","????????? ?????????","?????? ??????","?????????","????????????","?????????","???????????????","??????","?????????","????????????"
        };



        ArrayAdapter <String> kindadpter = new ArrayAdapter<String>(
                getActivity(),R.layout.support_simple_spinner_dropdown_item,dogkind);
        kindadpter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_i_kind.setAdapter(kindadpter);
        sp_i_kind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                edt_info_type.setText(dogkind[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            img_nose_print.setImageBitmap(imageBitmap);

//            Uri uri = data.getData();
//            Glide.with(getActivity().getApplicationContext()).load(uri).into(img_nose_print);


        }else if (requestCode == 1003 && resultCode == Activity.RESULT_OK){
            InputStream in = null;

            try {
                in = getActivity().getContentResolver().openInputStream(data.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
                Bitmap img = BitmapFactory.decodeStream(in);
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            img_nose_print.setImageBitmap(img);



        }
    }

    private ContentResolver getContentResolver() {
        return null;
    }
    public void sendRequest(){
        // Voolley Lib ????????? ???????????? ??????
        queue = Volley.newRequestQueue(getActivity());
        String url = "http://211.63.240.26:8081/YB/NosePrintService";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {
                Log.v("resultValue : ????????????",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String result = jsonObject.getString("dog_nose_print");
                    Log.v("resultValue",result);
                    if(!result.equals("??????")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("????????????").setMessage("??????????????? ?????????????????????.");
                        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(),Main.class);
                                startActivity(intent);
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        sendFlaskRequest(id);

                    }else if (result.equals("false")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("????????????").setMessage("??????????????? ?????????????????????.");

                        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(),Main.class);
                                startActivity(intent);
                            }
                        });

                        AlertDialog alertDialog = builder.create();

                        alertDialog.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            // ???????????? ?????? ????????? ??????
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override //response??? UTF8??? ??????????????? ????????????
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }

            // ?????? ???????????? ???????????? ???
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                id = PreferenceManager.getString(getActivity(),"id");

                BitmapDrawable drawable = (BitmapDrawable) img_nose_print.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                String filename = BitmapToBase64(bitmap);
                Log.v("bitmapp",filename);
                Log.v("?????????",sp_i_gender.getSelectedItem().toString());

                params.put("dog_name", edt_info_name.getText().toString());
                params.put("dog_gender",sp_i_gender.getSelectedItem().toString());
                params.put("dog_kind", sp_i_kind.getSelectedItem().toString());
                params.put("id", id);
                params.put("dog_picture", filename);




                return params;
            }
        };


        queue.add(stringRequest);
    }
    // Bitmap -> Base64 ??????
    public String BitmapToBase64(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] bImage = baos.toByteArray();
        String base64 = Base64.encodeToString(bImage, Base64.DEFAULT);
        return base64;
    }

    public void sendFlaskRequest(String id){
        Log.v("resultValue","??????????????? ?????? ???????????? ?????? ??????");
        queue = Volley.newRequestQueue(getActivity());
        String url = "http://211.63.240.26:5000/UploadNose?user_id="+id;
//        String url = "http://211.63.240.26:8081/YB/UploadNose?id="+id+"&filename="+filename;

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            // ?????????????????? ???????????? ???
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            // ???????????? ?????? ????????? ??????
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override //response??? UTF8??? ??????????????? ????????????
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }

        };


        queue.add(stringRequest);

    }
    public int exifOrientationToDegrees(int exifOrientation) {
      if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
        return 90;
      } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
          return 180;
      } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
          return 270;
      } return 0;
    }

    public Bitmap rotate(Bitmap bitmap, int degrees)
    {
        if(degrees != 0 && bitmap != null)
        {
            Matrix m = new Matrix();
            m.setRotate(degrees, (float) bitmap.getWidth() / 2,
                    (float) bitmap.getHeight() / 2);

            try
            {
                Bitmap converted = Bitmap.createBitmap(bitmap, 0, 0,
                        bitmap.getWidth(), bitmap.getHeight(), m, true);
                if(bitmap != converted)
                {
                    bitmap.recycle();
                    bitmap = converted;
                }
            }
            catch(OutOfMemoryError ex)
            {
                // ???????????? ???????????? ????????? ????????? ?????? ?????? ?????? ????????? ???????????????.
            }
        }
        return bitmap;
    }



}