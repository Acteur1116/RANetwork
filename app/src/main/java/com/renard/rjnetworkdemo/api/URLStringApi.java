package com.renard.rjnetworkdemo.api;

import com.renard.rjnetworkdemo.Fragment.news.detail.bean.NewsDetailInfo;
import com.renard.rjnetworkdemo.api.bean.NewsInfo;
import com.renard.rjnetwork.local.table.BeautyPhotoInfo;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.renard.rjnetworkdemo.api.RetrofitService.AVOID_HTTP403_FORBIDDEN;
import static com.renard.rjnetworkdemo.api.RetrofitService.CACHE_CONTROL_NETWORK;

/**
 * Created by Riven_rabbit on 2018/11/28
 */
public interface URLStringApi {
    /**
     * 获取新闻列表
     * eg: http://c.m.163.com/nc/article/headline/T1348647909107/60-20.html
     *      http://c.m.163.com/nc/article/list/T1348647909107/60-20.html
     *
     * @param type 新闻类型
     * @param id 新闻ID
     * @param startPage 起始页码
     * @return
     */
    @Headers(CACHE_CONTROL_NETWORK)
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<Map<String, List<NewsInfo>>> getNewsList(@Path("type") String type, @Path("id") String id,
                                                        @Path("startPage") int startPage);

    /**
     * 获取新闻详情
     * eg: http://c.3g.163.com/nc/article/BV56RVG600011229/full.html
     *
     * @param newsId 专题ID
     * @return
     */
    @Headers(AVOID_HTTP403_FORBIDDEN)
    @GET("nc/article/{newsId}/full.html")
    Observable<Map<String, NewsDetailInfo>> getNewsDetail(@Path("newsId") String newsId);

    /**
     * 获取美女图片，这个API不完整，省略了好多参数
     * eg: http://c.3g.163.com/recommend/getChanListNews?channel=T1456112189138&size=20&offset=0
     *
     * @param offset 起始页码
     * @return
     */
    @Headers(CACHE_CONTROL_NETWORK)
    @GET("recommend/getChanListNews?channel=T1456112189138&size=20")
    Observable<Map<String, List<BeautyPhotoInfo>>> getBeautyPhoto(@Query("offset") int offset);


}
