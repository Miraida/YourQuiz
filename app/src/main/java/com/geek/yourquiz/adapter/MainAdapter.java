package com.geek.yourquiz.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.yourquiz.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    List<String> list;
    IListener listener;

    public MainAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button btnLevel;
        String level;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.e("TAG", "MainViewHolder: itemView");
            btnLevel = itemView.findViewById(R.id.btn_level);
            btnLevel.setOnClickListener(this);
        }

        public void onBind(String level) {
            this.level = level;
            btnLevel.setText(level);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(getAdapterPosition());
            }
        }
    }

    public void setOnClickListener(IListener mListener) {
        this.listener = mListener;
    }

    public interface IListener {
        void onItemClick(int position);
    }
}
