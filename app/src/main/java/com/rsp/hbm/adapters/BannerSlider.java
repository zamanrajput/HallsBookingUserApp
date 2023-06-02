package com.rsp.hbm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsp.ohb.R;

import java.util.List;


public class BannerSlider extends RecyclerView.Adapter<BannerSlider.ViewHolder> {
    private final List<SliderItem> itemList;


    public BannerSlider(List<SliderItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_banner_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(itemList.get(position));
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv;
        private final TextView titleTV, descriptionTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
            titleTV = itemView.findViewById(R.id.title);
            descriptionTV = itemView.findViewById(R.id.descriptions);
        }

        void setData(SliderItem sliderItem) {
            iv.setImageResource(sliderItem.image);
            titleTV.setText(sliderItem.title);
            descriptionTV.setText(sliderItem.descriptions);
        }
    }

}
