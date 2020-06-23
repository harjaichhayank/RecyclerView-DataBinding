package com.example.recyclerViewDataBinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerViewDataBinding.databinding.RowLayoutBinding;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private List<Movie> movies;

    RecyclerViewAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutBinding rowLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.row_layout,parent,false);
        return new RecyclerViewHolder(rowLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.rowLayoutBinding.setMovie(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        RowLayoutBinding rowLayoutBinding;

        RecyclerViewHolder(@NonNull RowLayoutBinding itemView) {
            super(itemView.getRoot());
            rowLayoutBinding = itemView;
        }
    }
}
