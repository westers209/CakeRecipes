package com.example.cakerecipes.view;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cakerecipes.R;
import com.example.cakerecipes.model.CakeDetailsPojo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    //todo need the dataset
    List<CakeDetailsPojo> dataSet;

    public void setDataSet(List<CakeDetailsPojo> data) {
        this.dataSet = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.textView.setText(dataSet.get(i).title);
        Picasso.get()
                .load(dataSet.get(i).image)
                .into(customViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
