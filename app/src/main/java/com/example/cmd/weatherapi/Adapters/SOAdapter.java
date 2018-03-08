package com.example.cmd.weatherapi.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cmd.weatherapi.R;
import com.example.cmd.weatherapi.ViewHolders.SOViewHolder;
import com.example.cmd.weatherapi.data.model.Item;

import java.util.List;

/**
 * Created by cmd on 8.03.18.
 */

public class SOAdapter extends RecyclerView.Adapter<SOViewHolder> {

    private List<Item> mList;
    private Context ctx;

    public SOAdapter(List<Item> mList, Context ctx) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @Override
    public SOViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SOViewHolder(LayoutInflater.from(ctx)
                .inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(SOViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position).getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void updateItems(List<Item> items) {
        mList = items;
        notifyDataSetChanged();
    }

    private Item getAdapterItem(int adapterPosition) {
        return mList.get(adapterPosition);
    }
}
