package com.renard.rjnetworkdemo.adapter;

import android.content.Context;

import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.adapter.BaseViewHolder;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.local.table.NewsTypeInfo;

import java.util.List;

/**
 * Created by Riven_rabbit on 2018/12/3
 */
public class ManageAdapter extends BaseQuickAdapter<NewsTypeInfo> {

    public ManageAdapter(Context context) {
        super(context);
    }

    public ManageAdapter(Context context, List<NewsTypeInfo> data) {
        super(context, data);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_manage;
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsTypeInfo item) {
        holder.setText(R.id.tv_channel_name, item.getName());
    }
}
