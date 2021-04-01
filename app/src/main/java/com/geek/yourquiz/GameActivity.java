package com.geek.yourquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
     TextView txtLevel,txtQuestion;
     Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4;
     QuestionModel model ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initViews();
        getQuestions();
    }
    private void initViews() {
        txtLevel = findViewById(R.id.level_textView);
        txtQuestion = findViewById(R.id.question_textView);
        btnAnswer1 = findViewById(R.id.button);
        btnAnswer2 = findViewById(R.id.button2);
        btnAnswer3 = findViewById(R.id.button3);
        btnAnswer4 = findViewById(R.id.button4);
    }

    private void getQuestions() {
        model = (QuestionModel) getIntent().getSerializableExtra("firstKey");
        if (model!=null){
            setQuestions();
        }
    }
    private void setQuestions() {
        txtLevel.setText(model.getCurrentLevel());
        txtQuestion.setText(model.getQuestion());
        btnAnswer1.setText(model.getFirstAnswer());
        btnAnswer2.setText(model.getSecondAnswer());
        btnAnswer3.setText(model.getThirdAnswer());
        btnAnswer4.setText(model.getFourthAnswer());
        setButtonClickListener();
    }
 private void setButtonClickListener(){
     btnAnswer1.setOnClickListener(this);
     btnAnswer2.setOnClickListener(this);
     btnAnswer3.setOnClickListener(this);
     btnAnswer4.setOnClickListener(this);
 }

    @Override
    public void onClick(View v) {
        int correctAnswer = checkLevelCorrectAnswer();

        if (v.getId() == btnAnswer3.getId() && correctAnswer==3){
            showDialog(":) Correct!");
        }
        else if (v.getId() == btnAnswer2.getId() && correctAnswer==2){
            showDialog(":) Correct!");
        }
        else if (v.getId() == btnAnswer1.getId() && correctAnswer==1){
            showDialog(":) Correct!");
        }
        else {
            showDialog(";( Not correct!");
        }
    }


    private int checkLevelCorrectAnswer() {
        switch (model.getCurrentLevel()){
            case "Level 1": return 3;
            case "Level 2":  return 2;
            case "Level 3": return 1;
        }
        return 0;
    }
    private void showDialog(String isCorrect){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(GameActivity.this);
        builder1.setTitle(isCorrect);
        builder1.setMessage(getCorrectAnswerDescription());
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Back to Levels",
                (dialog, id) -> finish());

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    private String getCorrectAnswerDescription() {
        switch (model.getCurrentLevel()){
            case "Level 1": return "You can override onCreateView() to programmatically inflate or create your fragment's view.";
            case "Level 2":  return "You can use Layout-large Android resource directory  for tablets";
            case "Level 3": return "Firebase Cloud Messaging (FCM), formerly known as Google Cloud Messaging (GCM), is a cross-platform cloud solution for messages" +
                    " and notifications for Android, iOS, and web applications, which currently can be used at no cost.";
        }
        return "";
    }


}