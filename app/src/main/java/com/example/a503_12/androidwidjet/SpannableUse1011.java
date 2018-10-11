package com.example.a503_12.androidwidjet;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class SpannableUse1011 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_use1011);

        //TextView 찾아오기
        TextView textview = (TextView)findViewById(R.id.textview);
        //스크롤 기능을 하도록 설정
        textview.setMovementMethod(new ScrollingMovementMethod());

        String data = "안녕하세요\n green \n 텍스트 중간에 이미지를 출력하고 제목 부분만 서식을 변경합니다.";

        //img 부분에 이미지 삽입하기
        SpannableStringBuilder ssb = new SpannableStringBuilder(data);

        //삽입할 시작 위치 찾기
        int start = data.indexOf("green");

        //삽입할 종료 위치 찾기
        int end = start + "green".length();

        //출력할 이미지 찾아오기
        Drawable dr = ResourcesCompat.getDrawable(getResources(), R.drawable.green, null);

        //이미지 추출하기
        dr.setBounds(0,0,dr.getIntrinsicWidth(), dr.getIntrinsicHeight());

        //이미지를 출력하기위한 Span 만들기
        ImageSpan imageSpan = new ImageSpan(dr);

        //SapnnableBuilder에 적용
        ssb.setSpan(imageSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        //안녕하세요 부분의 서식 변경
        start = data.indexOf("안녕하세요");
        end = start + "안녕하세요".length();
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.0f);
        ssb.setSpan(styleSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(sizeSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //텍스트 뷰에 적용
        textview.setText(ssb);
    }
}
