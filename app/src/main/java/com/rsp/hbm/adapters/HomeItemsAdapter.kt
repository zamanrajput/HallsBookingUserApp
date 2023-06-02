package com.rsp.hbm.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rsp.hbm.Hall
import com.rsp.ohb.R
import com.rsp.ohb.databinding.HallRecItemBinding

class HomeItemsAdapter(
    private val mCtx: Activity,
    private val list: ArrayList<Hall> = ArrayList(),
) :

    RecyclerView.Adapter<HomeItemsAdapter.Holder>() {


    class Holder(private val binding: HallRecItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hall: Hall) = with(binding) {
            name.text = hall.name

            address.text = hall.address
            Glide.with(name.context).load(hall.cover).placeholder(R.drawable.i2).into(imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        HallRecItemBinding.inflate(
            LayoutInflater.from(mCtx), parent, false
        )
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }
}