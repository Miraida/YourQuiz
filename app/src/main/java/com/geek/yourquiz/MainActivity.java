package com.geek.yourquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private Button btnReviews;
    private Button btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initClickers();
    }

    private void initViews() {
        btnStart = findViewById(R.id.btn_start);
        btnReviews = findViewById(R.id.btn_reviews);
        btnExit = findViewById(R.id.btn_exit);
    }

    private void initClickers() {
        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,LevelActivity.class);
            intent.putExtra("key1","Level 1");
            intent.putExtra("key2","Level 2");
            intent.putExtra("key3","Level 3");
            startActivity(intent);
        });
        btnReviews.setOnClickListener(v -> {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, rate my app!");
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });

        btnExit.setOnClickListener(v -> finish());

    }


}