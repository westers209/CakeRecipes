package com.example.cakerecipes.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cakerecipes.R;

class CustomViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.cakeImage);
        textView = itemView.findViewById(R.id.cakeTitle);
    }

}
