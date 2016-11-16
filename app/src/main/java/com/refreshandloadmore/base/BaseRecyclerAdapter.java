package com.refreshandloadmore.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 基类
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    public List<T> datas;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return createHolder(context, parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindData(holder, position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //使用泛型来控制返回类型
    public abstract <T extends RecyclerView.ViewHolder> T createHolder(Context context, ViewGroup parent);

    public abstract void bindData(RecyclerView.ViewHolder viewHolder, int position);
}
