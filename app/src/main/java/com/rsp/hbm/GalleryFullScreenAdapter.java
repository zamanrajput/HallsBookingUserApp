package com.rsp.hbm;


import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsp.ohb.R;

import java.util.List;

public class GalleryFullScreenAdapter extends RecyclerView.Adapter<GalleryFullScreenAdapter.ViewHolder> {
    private final List<String> itemList;
    private final BaseActivity mContext;

    public GalleryFullScreenAdapter(BaseActivity activity, List<String> itemList) {
        this.itemList = itemList;
        mContext = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.full_screen_gallery_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setImage(itemList.get(position), position);
        holder.itemView.setOnClickListener(v -> {

        });
        holder.itemView.setOnLongClickListener(v -> false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.itemView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv;
        TextView tv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.imageView);
        }

        void setImage(String s, int pos) {
//            Glide.with(mContext).load(s).placeholder(R.drawable.).into(iv);
//            tv.setText((pos + 1) + "/" + getItemCount());
        }
    }

}