package com.example.nongsan.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nongsan.R;
import com.example.nongsan.data.model.Category;


import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
private List<Category> categoryList;

public CategoryAdapter(List<Category> categoryList){
        this.categoryList = categoryList;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_category, parent, false);

        return new ViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.tvName.setText(category.name);
        }

@Override
public int getItemCount() {
        return categoryList.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView tvName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);

    }
}
}