package com.example.cmd.weatherapi.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.cmd.weatherapi.R;

/**
 * Created by cmd on 8.03.18.
 */

public class SOViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextView;

    public SOViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView)itemView.findViewById(R.id.textViewTest);
    }

}
