package com.rsp.hbm.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsp.ohb.R;

import java.util.List;

public class ImagesSliderAdapter extends RecyclerView.Adapter<ImagesSliderAdapter.ViewHolder> {
    private final List<Integer> itemList;


    public ImagesSliderAdapter(List<Integer> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setImage(itemList.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itemView.setOnLongClickListener(v -> false);

    }
    


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.imageView);
        }

        void setImage(int image, int pos) {
            iv.setImageResource(image);
        }
    }

}