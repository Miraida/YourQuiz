package com.geek.yourquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.geek.yourquiz.fragments.StartFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFragment();
    }
    private void openFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new StartFragment()).commit();
    }
}