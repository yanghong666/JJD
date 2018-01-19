package com.example.loginandregistration.net;

import com.example.loginandregistration.bean.Bean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 杨洪 on 2018/1/10.
 */

public interface ApiService {
  //  http://120.27.23.105/user/login?mobile=15004595102&password=111111
    @GET("user/login")
    Flowable<Bean> get(@QueryMap Map<String,String> map);
}

