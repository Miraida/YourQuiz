package com.geek.yourquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity {
     private String firstLevel,secondLevel,thirdLevel;
     Button btnLevel1,btnLevel2,btnLevel3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        getLevels();
        initViews();
        setLevels();
        sendQuestions();
    }


    private void getLevels() {
        if (getIntent()!=null){
            Intent intent = getIntent();
            firstLevel = intent.getStringExtra("key1");
            secondLevel = intent.getStringExtra("key2");
            thirdLevel = intent.getStringExtra("key3");
        }
    }

    private void initViews() {
        btnLevel1 = findViewById(R.id.level1);
        btnLevel2 = findViewById(R.id.level2);
        btnLevel3 = findViewById(R.id.level3);

    }

    private void setLevels() {
        btnLevel1.setText(firstLevel);
        btnLevel2.setText(secondLevel);
        btnLevel3.setText(thirdLevel);
    }

    private void sendQuestions() {
        Intent intent  = new Intent(LevelActivity.this,GameActivity.class);
        btnLevel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("firstKey", new QuestionModel(firstLevel,"Which method initiate the fragment?",
                        "OnViewCreate()","OnCreate()","OnCreateView()","OnAttach()"));
                startActivity(intent); }
        });

        btnLevel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("firstKey", new QuestionModel(secondLevel,"What Android resource directory do we use store our .xml layout file for tablets?",
                        "Layout","Layout-large","Layout-tablet","The name does not matter"));
                startActivity(intent); }
        });
        btnLevel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("firstKey", new QuestionModel(thirdLevel,"What does FCM stand for?",
                        "Firebase Cloud Messaging","FireBase Cloud Manager","FireBase Cloud Mediator","None of the Above"));
                startActivity(intent); }
        });
    }

}