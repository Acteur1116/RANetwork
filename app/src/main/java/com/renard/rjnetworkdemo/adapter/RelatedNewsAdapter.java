package com.renard.rjnetworkdemo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.adapter.BaseViewHolder;
import com.renard.rjnetwork.utils.DefIconFactory;
import com.renard.rjnetwork.utils.ImageLoader;
import com.renard.rjnetwork.utils.StringUtils;
import com.renard.rjnetworkdemo.Fragment.news.detail.NewsDetailActivity;
import com.renard.rjnetworkdemo.Fragment.news.detail.bean.NewsItemInfo;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.adapter.item.NewsMultiItem;
import com.renard.rjnetworkdemo.api.bean.NewsInfo;

import java.util.List;

/**
 * Created by Riven_rabbit on 12/9/20
 *
 * @author suyanan
 */
public class RelatedNewsAdapter extends BaseQuickAdapter<NewsItemInfo> {
    public RelatedNewsAdapter(Context context) {
        super(context);
    }

    public RelatedNewsAdapter(Context context, List<NewsItemInfo> data){
        super(context,data);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_news_list;
    }

    @Override
    protected void convert(BaseViewHolder holder, final NewsItemInfo item) {
        ImageView newsIcon = holder.getView(R.id.iv_icon);
        ImageLoader.loadCenterCrop(mContext, item.getImgsrc(), newsIcon, DefIconFactory.provideIcon());
        holder.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_source, StringUtils.clipNewsSource(item.getSource()))
                .setText(R.id.tv_time, item.getPtime());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailActivity.launch(mContext, item.getId());
            }
        });
    }
}
