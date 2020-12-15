package com.renard.rjnetworkdemo.Fragment.news.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewStub;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.renard.richtext.callback.OnUrlClickListener;
import com.renard.rjnetwork.Base.BasePresenter;
import com.renard.rjnetwork.Base.BaseSwipeBackActivity;
import com.renard.rjnetwork.recyclerview.adapter.BaseQuickAdapter;
import com.renard.rjnetwork.recyclerview.helper.RecyclerViewHelper;
import com.renard.rjnetwork.utils.ListUtils;
import com.renard.rjnetworkdemo.Fragment.news.detail.bean.NewsDetailInfo;
import com.renard.rjnetworkdemo.R;
import com.renard.rjnetworkdemo.api.NewsUtils;
import com.renard.rjnetworkdemo.injector.components.DaggerNewsDetailComponent;
import com.renard.rjnetworkdemo.injector.modules.NewsDetailModule;
import com.renard.richtext.RichText;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Riven_rabbit on 12/8/20
 *
 * @author suyanan
 */
public class NewsDetailActivity extends BaseSwipeBackActivity<BasePresenter> implements NewsDetailView{

    private static final String APP_KEY = "AppKey";

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.fab_coping)
    FloatingActionButton mFabCoping;
    @BindView(R.id.tv_source)
    TextView mTvSource;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.sv_content)
    NestedScrollView mSvContent;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    @Inject
    BaseQuickAdapter mRelatedAdapter;

    private String mNewsId;

    public static void launch(Context context,String newsId){
        Intent intent=new Intent(context,NewsDetailActivity.class);
        intent.putExtra(APP_KEY,newsId);
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.slide_right_entry, R.anim.hold);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initInjector() {
        mNewsId = getIntent().getStringExtra(APP_KEY);
        DaggerNewsDetailComponent.builder()
                .newsDetailModule(new NewsDetailModule(mNewsId,this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        initToolBar(mToolBar, true, "新闻详情");
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(NewsDetailInfo newsDetailBean) {
        mTvTitle.setText(newsDetailBean.getTitle());
        mTvSource.setText(newsDetailBean.getSource());
        mTvTime.setText(newsDetailBean.getPtime());
        RichText.from(newsDetailBean.getBody())
                .into(mTvContent,this);
        _handleSpInfo(newsDetailBean.getSpinfo());
        _handleRelatedNews(newsDetailBean);
    }

    /**
     * 处理关联的内容
     *
     * @param spinfo
     */
    private void _handleSpInfo(List<NewsDetailInfo.SpinfoEntity> spinfo) {
        if (!ListUtils.isEmpty(spinfo)) {
            ViewStub stub = (ViewStub) findViewById(R.id.vs_related_content);
            assert stub != null;
            stub.inflate();
            TextView tvType = (TextView) findViewById(R.id.tv_type);
            TextView tvRelatedContent = (TextView) findViewById(R.id.tv_related_content);
            tvType.setText(spinfo.get(0).getSptype());
            RichText.from(spinfo.get(0).getSpcontent())
                    .urlClick(new OnUrlClickListener() {
                        @Override
                        public boolean urlClicked(String url) {
                            Logger.e(url);
                            String newsId = NewsUtils.clipNewsIdFromUrl(url);
                            Logger.w(url);
                            if (newsId != null) {
                                launch(NewsDetailActivity.this, newsId);
                            }
                            return true;
                        }
                    })
                    .into(tvRelatedContent,this);
        }
    }

    /**
     * 处理关联新闻
     *
     * @param newsDetailBean
     */
    private void _handleRelatedNews(NewsDetailInfo newsDetailBean) {
        if (!ListUtils.isEmpty(newsDetailBean.getRelative_sys())) {
            ViewStub stub = (ViewStub) findViewById(R.id.vs_related_news);
            assert stub != null;
            stub.inflate();
            TextView mTvTopicName = (TextView) findViewById(R.id.tv_topic_name);
            if (!ListUtils.isEmpty(newsDetailBean.getHuati())) {
                mTvTopicName.setText(newsDetailBean.getHuati().get(0).getTopicName());
            }
            RecyclerView mRvRelatedNews = (RecyclerView) findViewById(R.id.rv_related_news);
            RecyclerViewHelper.initRecyclerViewV(this, mRvRelatedNews, false, mRelatedAdapter);
            mRelatedAdapter.updateItems(newsDetailBean.getRelative_sys());
        }
    }

    @OnClick(R.id.fab_coping)
    public void onClick() {
        mSvContent.stopNestedScroll();
        mSvContent.smoothScrollTo(0, 0);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.hold, R.anim.slide_right_exit);
    }
}
