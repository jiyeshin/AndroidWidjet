package com.example.a503_12.androidwidjet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarUse1011 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_use1011);

        final ProgressBar lect = (ProgressBar)findViewById(R.id.progress1);
        final ProgressBar circle = (ProgressBar)findViewById(R.id.progress2);

        //여러 개의 클릭 이벤트를 처리하기 위한 핸들러 만들기
        View.OnClickListener eventHandler = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnstart:
                        lect.setProgress(lect.getProgress()+20);
                        circle.setVisibility(View.VISIBLE);
                        break;
                    case R.id.btnstop:
                        lect.setProgress(lect.getProgress()-20);
                        circle.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        };
        Button btnstart = (Button)findViewById(R.id.btnstart);
        Button btnstop = (Button)findViewById(R.id.btnstop);
        btnstart.setOnClickListener(eventHandler);
        btnstop.setOnClickListener(eventHandler);
    }
}
