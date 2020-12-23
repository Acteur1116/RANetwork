package com.renard.rjnetworkdemo.api;

import com.renard.rjnetwork.local.table.BeautyPhotoInfo;
import com.renard.rjnetworkdemo.api.bean.WelfarePhotoList;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.renard.rjnetworkdemo.api.RetrofitService.CACHE_CONTROL_NETWORK;

/**
 * Created by Riven_rabbit on 2018/12/3
 */
public interface IWelfareApi {
    /**
     * 获取福利图片
     * eg: http://gank.io/api/data/福利/10/1
     *
     * @param page 页码
     * @return
     */
    @Headers(CACHE_CONTROL_NETWORK)
    @GET("/api/v2/data/category/Girl/type/Girl/page/1/count/{page}")
//    Observable<WelfarePhotoList> getWelfarePhoto(@Path("page") int page);
    Observable<Map<String, List<BeautyPhotoInfo>>> getBeautyPhoto(@Path("page") int page);


    @Headers(CACHE_CONTROL_NETWORK)
    @GET("/api/v2/data/category/Girl/type/Girl/page/1/count/{page}")
    Observable<WelfarePhotoList> getWelfarePhoto(@Path("page") int page);
//    Observable<Map<String, List<BeautyPhotoInfo>>> getBeautyPhoto(@Path("page") int page);

}
