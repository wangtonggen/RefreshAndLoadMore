package com.refreshandloadmore.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.refreshandloadmore.R;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 描述
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public RecyclerViewHolder(View view){
        super(view);
        textView = (TextView) view.findViewById(R.id.textView);
    }
}
