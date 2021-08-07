package com.example.findyourdog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Question_Result extends AppCompatActivity {

    private TextView tv_question,tv_question_re,tv_question_result,tv_question_reuslt_re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_result);

        tv_question = findViewById(R.id.tv_question);
        tv_question_re = findViewById(R.id.tv_question_re);
        tv_question_result = findViewById(R.id.tv_question_result);
        tv_question_reuslt_re = findViewById(R.id.tv_question_reuslt_re);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        tv_question.setText(title);
        if (title.equals("Q. 유기견을 발견하면 어떻게 해야 하나요?")){
            tv_question_re.setText("");
            tv_question_result.setText("");
            tv_question_reuslt_re.setText("");
        }else if(title.equals("Q. 보호소 연결이 안 될 경우엔 어떡하죠?")){
            tv_question_re.setText("");
            tv_question_result.setText("");
            tv_question_reuslt_re.setText("");
        }else if(title.equals("Q. 유기견 입양하고 싶은데 절차가 어떻게 되나요?")){
            tv_question_re.setText("");
            tv_question_result.setText("");
            tv_question_reuslt_re.setText("");
        }else if(title.equals("Q. 비문 등록 잘하는 방법이 궁금해요 !")){
            tv_question_re.setText("");
            tv_question_result.setText("");
            tv_question_reuslt_re.setText("");
        }else if(title.equals("Q. 비문 등록을 여러개 해놓아도 되나요?")){
            tv_question_re.setText("");
            tv_question_result.setText("");
            tv_question_reuslt_re.setText("");
        }
        Log.v("title",title);
    }


}