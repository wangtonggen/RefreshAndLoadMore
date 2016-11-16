package com.refreshandloadmore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.refreshandloadmore.R;
import com.refreshandloadmore.base.BaseRecyclerAdapter;
import com.refreshandloadmore.holder.RecyclerViewHolder;

import java.util.List;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 描述
 */

public class RecyclerViewAdapter extends BaseRecyclerAdapter<String>{
    public RecyclerViewAdapter(List<String> datas){
        this.datas = datas;
    }
    @Override
    public <T extends RecyclerView.ViewHolder> T createHolder(Context context, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return (T)holder;
    }

    @Override
    public void bindData(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerViewHolder holder = (RecyclerViewHolder) viewHolder;
        holder.textView.setText(datas.get(position));
    }
}
