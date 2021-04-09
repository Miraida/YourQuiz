package com.geek.yourquiz.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geek.yourquiz.AlertDialogClass;
import com.geek.yourquiz.model.QuestionModel;
import com.geek.yourquiz.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameFragment extends Fragment implements View.OnClickListener {
    TextView txtLevel, txtQuestion;
    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    QuestionModel model;
    String[] answers = new String[4];
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        initViews();
        getQuestions();
        setQuestions();
    }

    private void initViews() {
        txtLevel = view.findViewById(R.id.level_textView);
        txtQuestion = view.findViewById(R.id.question_textView);
        btnAnswer1 = view.findViewById(R.id.button);
        btnAnswer2 = view.findViewById(R.id.button2);
        btnAnswer3 = view.findViewById(R.id.button3);
        btnAnswer4 = view.findViewById(R.id.button4);
    }

    private void getQuestions() {
        model = (QuestionModel) getArguments().getSerializable("question");
        if (model != null) {
            mixAnswers();
            setQuestions();
        }
    }

    private void mixAnswers() {
        String[] answers2 = new String[]{model.getFirstAnswer(), model.getSecondAnswer(), model.getThirdAnswer(), model.getFourthAnswer()};
        Integer[] array = new Integer[]{0, 1, 2, 3};
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answers2[list.get(i)];
        }
        Log.e("TAG", "mixAnswers: " + list.toString());
    }

    private void setQuestions() {
        txtLevel.setText(model.getCurrentLevel());
        txtQuestion.setText(model.getQuestion());
        btnAnswer1.setText(answers[0]);
        btnAnswer2.setText(answers[1]);
        btnAnswer3.setText(answers[2]);
        btnAnswer4.setText(answers[3]);
        setButtonClickListener();
    }

    private void setButtonClickListener() {
        btnAnswer1.setOnClickListener(this);
        btnAnswer2.setOnClickListener(this);
        btnAnswer3.setOnClickListener(this);
        btnAnswer4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = view.findViewById(v.getId());

        switch (model.getCurrentLevel()) {
            case "1":
                showDialog(button.getText().equals("Nowhere, it is still there."));
                break;
            case "2":
                showDialog(button.getText().equals("576 Mega pixels"));
                break;
            case "3":
                showDialog(button.getText().equals("Nothing"));
                break;
        }
    }

    private void showDialog(boolean isTrue) {
        String title;
        int icon;
        if (isTrue) {
            title = "Correct!";
            icon = R.drawable.ic_baseline_check_24;
        } else {
            title = "Incorrect!";
            icon = R.drawable.ic_wrong;
        }
        AlertDialog dialog = new AlertDialogClass(requireContext(), title, "", icon).getDialog();
        dialog.show();
    }
}