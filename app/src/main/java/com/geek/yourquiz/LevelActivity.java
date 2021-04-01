package com.geek.yourquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity implements MainAdapter.IListener {
    private final List<String> list =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        checkLevels();
        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MainAdapter adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
        Log.e("TAG", "LevelActivity: adapter" );
    }
    private void checkLevels() {
        Intent intent = getIntent();
        if (intent!=null){
            list.add(intent.getStringExtra("key1")) ;
            list.add(intent.getStringExtra("key2")) ;
            list.add(intent.getStringExtra("key3")) ;
        }
    }
    @Override
    public void onItemClick(String level) {
        Log.e("TAG", "sendQuestions: LevelActivity" );
        Intent intent = new Intent(LevelActivity.this,GameActivity.class);
        switch (level){
            case "Level 1":  intent.putExtra("firstKey", new QuestionModel(level,"Which method initiate the fragment?",
                   "OnViewCreate()","OnCreate()","OnCreateView()","OnAttach()"));
                  break;
            case "Level 2":      intent.putExtra("firstKey", new QuestionModel(level,"What Android resource directory do we use store our .xml layout file for tablets?",
                   "Layout","Layout-large","Layout-tablet","The name does not matter"));
                  break;
            case "Level 3":     intent.putExtra("firstKey", new QuestionModel(level,"What does FCM stand for?",
                   "Firebase Cloud Messaging","FireBase Cloud Manager","FireBase Cloud Mediator","None of the Above"));
                  break;
            default: break;
        }
        startActivity(intent);
    }
}