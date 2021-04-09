package com.geek.yourquiz.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geek.yourquiz.R;

public class StartFragment extends Fragment {
    Button btnStart, btnReviews, btnExit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        btnStart.setOnClickListener(v -> sendLevels());
        btnReviews.setOnClickListener(v -> reviewMethod());
        btnExit.setOnClickListener(v -> exit());
    }

    private void initViews(View v) {
        btnStart = v.findViewById(R.id.btn_start);
        btnReviews = v.findViewById(R.id.btn_reviews);
        btnExit = v.findViewById(R.id.btn_exit);
    }

    private void sendLevels() {
        Bundle bundle = new Bundle();
        bundle.putString("key1", "1");
        bundle.putString("key2", "2");
        bundle.putString("key3", "3");
        LevelFragment levelFragment = new LevelFragment();
        levelFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, levelFragment).commit();
    }

    private void exit() {
        requireActivity().finish();
    }

    private void reviewMethod() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.SEND_RESPOND_VIA_MESSAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(
                    new String[]{Manifest.permission.SEND_RESPOND_VIA_MESSAGE},
                    2000);
        }else{
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setData(Uri.parse("Hey there, please rate my app!"));
        requireActivity().startActivity(intent);
        }
    }
}
