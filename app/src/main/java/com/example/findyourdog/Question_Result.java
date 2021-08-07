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
            tv_question_re.setText("길에서 주인없는 강아지를 발견하셨나요?");
            tv_question_result.setText("그럴때는 당황하지 마시고 발견하신 지역의 시군구청으로 전화를 걸어서 유기동물 담당부서를 알려달라고 요청해보세요!" );
            tv_question_reuslt_re.setText("담당자와 연결되면 발견장소, 동물의 상태를 상세히 설명하시고 신고자의 이름과 연락처를 알려주세요~" +
                    "최근에는 유기동물 신고접수량이 많아 바로 출동이 어려운 경우가 있으니, 그 부분은 양해해주시고 담당자분과 대화를 통해서 방법을 모색하시는 것이 좋습니다.");
        }else if(title.equals("Q. 보호소 연결이 안 될 경우엔 어떡하죠?")){
            tv_question_re.setText("보호소 연결이 안되시나요?");
            tv_question_result.setText("보호소에서 전화를 받지 못할 때가 종종 있어요. 이럴때는 관할 시군구청 유기동물 담당부서로 전화해보세요!");
            tv_question_reuslt_re.setText("보호소마다 차이는 있지만, 앱에 나와있는 보호소 전화번호로 전화해보면 연결이 쉽지 않거나,간혹 연결이 쉽지 않거나 연결이 되더라도 친절하게 설명받지 못하는 경우도 있을 수 있습니다." +
                    " 많은 보호소들이 아직 많은 직원들에 의해 운영되는 게 아니기 때문에 불가피하게 연락이 안되는 경우도 있습니다. ");
        }else if(title.equals("Q. 유기견 입양하고 싶은데 절차가 어떻게 되나요?")){
            tv_question_re.setText("새로운 가족을 찾고 계시나요?");
            tv_question_result.setText("유기견을 입양하려면 먼저 가까운 보호소에 문의해보세요. 담당자 안내에 따라 사전 질문지나 양식에 답변을 작성하여 보내야해요. ");
            tv_question_reuslt_re.setText(
                    "그 후 예약한 날짜와 시간에 유기견 신청자가 직접 보호소에 방문하여 상담하고 입양 계약서를 작성한 후 입양동물을 데려오는 것이 일반적인 절차입니다." +
                    "이후 필요한 서류 작성을 마친 후 입양하시면 됩니다." +
                    "중성화 및 동물등록은 필수입니다.");
        }else if(title.equals("Q. 비문 등록 잘하는 방법이 궁금해요 !")){
            tv_question_re.setText("비문 등록이 잘 안되시나요? ");
            tv_question_result.setText("그럼 다음 방법으로 등록해보세요! " +
                    "촬영 환경을 다시 조성해주세요. 자연광 혹은 아주 밝은 형광등, LED조명 아래에서 비문등록을 시도하시면 더 수월하답니다.");
            tv_question_reuslt_re.setText("오래된 형광등이나 백열등 전구 밑에서 촬영하시면 비문 등록이 어렵습니다.");
        }else if(title.equals("Q. 비문 등록을 여러개 해놓아도 되나요?")){
            tv_question_re.setText("한마리가 아닌 여러 반려견을 키우고 계시나요? ");
            tv_question_result.setText("저희 '찾아줄개'에서는 여러개의 비문등록이 가능합니다. 새로운 반려견을 입양할 때마다 미래의 위험한 상황을 대비하여 비문을 등록해주세요.");
            tv_question_reuslt_re.setText("당신의 소중한 반려견을 잃어버릴 시 수월하고 빠르게 찾아줄 수 있어요. 비문등록 잊지마세요!");
        }
        Log.v("title",title);
    }


}