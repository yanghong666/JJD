package com.example.twoweek.net;


import com.example.twoweek.bean.DanSpBean;
import com.example.twoweek.bean.GwcBean;
import com.example.twoweek.bean.JgBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 杨洪 on 2018/1/8.
 */

public interface ApiService {

    @GET("product/getCarts")//?uid=3416&source=android//?source=android
    Flowable<GwcBean> get(@QueryMap Map<String,String> map);


    @GET("product/deleteCart")//?uid=3416&source=android//?source=android
    Flowable<GwcBean> getdel(@QueryMap Map<String,String> map);

//      http://120.27.23.105/?uid=3416&source=android&pid=1



    @GET("product/getProductDetail")
    Flowable<DanSpBean> getshowdan(@QueryMap Map<String,String> map);


    @GET("product/addCart")
    Flowable<JgBean> getadd(@QueryMap Map<String,String> map);



}
