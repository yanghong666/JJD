package com.example.loginandregistration.net;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 杨洪 on 2018/1/10.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    private final Retrofit retrofit;

    private RetrofitUtils(String baseurl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtils getInstance(String basgeurl) {
        if (instance == null) {
            synchronized (RetrofitUtils.class) {
                if (instance == null) {
                    Log.e("yh", "getInstance: "+basgeurl );
                    instance = new RetrofitUtils(basgeurl);
                }
            }
        }
        return instance;
    }

    public Retrofit getretrofit(){
        return retrofit;
    }

}
