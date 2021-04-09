package com.geek.yourquiz.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.yourquiz.AlertDialogClass;
import com.geek.yourquiz.adapter.MainAdapter;
import com.geek.yourquiz.model.QuestionModel;
import com.geek.yourquiz.R;

import java.util.ArrayList;
import java.util.List;

public class LevelFragment extends Fragment implements MainAdapter.IListener {
    private final List<String> list = new ArrayList<>();
    String firstLevel, secondLevel, thirdLevel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_level, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkLevels();
        initViews(view);
    }

    private void initViews(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        MainAdapter adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
        Log.e("TAG", "LevelActivity: adapter");
    }

    private void checkLevels() {
        if (getArguments() != null) {
            firstLevel = getArguments().getString("key1");
            secondLevel = getArguments().getString("key2");
            thirdLevel = getArguments().getString("key3");
            addList();
        }
    }

    private void addList() {
        list.add(firstLevel);
        list.add(secondLevel);
        list.add(thirdLevel);
    }

    @Override
    public void onItemClick(int position) {
        sendQuestions(position);
    }

    private void sendQuestions(int position) {
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                bundle.putSerializable("question", new QuestionModel(firstLevel, "Where Do Permanently Deleted Files Go In Computers?",
                        "SomeWhere", "I don't know", "Nowhere, it is still there.", "To the trash"));
                break;
            case 1:
                bundle.putSerializable("question", new QuestionModel(secondLevel, "What Is The Resolution Of The Human Eye?"
                        , "576 Mega pixels", "345 Mega pixels", "64 Mega pixels", "5 Mega pixels"));
                break;
            case 2:
                bundle.putSerializable("question", new QuestionModel(thirdLevel, "What If Everyone On Earth Jumped At Once?",
                        "I don't know", "Nothing", "The earth will be out of its orbit", "There will be earthquakes"));
                break;
            default:
                break;
        }
        if (bundle != null) {
            GameFragment gameFragment = new GameFragment();
            gameFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, gameFragment).commit();
        } else ifError();
    }

    private void ifError() {
        AlertDialogClass alertDialog = new AlertDialogClass(requireContext(), "Oops, something gone wrong!"
                , "", R.drawable.ic_baseline_error);
        AlertDialog dialog = alertDialog.getDialog();
        dialog.show();
    }
}