package com.example.loginandregistration.model;

import com.example.loginandregistration.bean.Bean;
import com.example.loginandregistration.net.ApiService;
import com.example.loginandregistration.net.RetrofitUtils;
import com.example.loginandregistration.presenter.Presenter;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by 杨洪 on 2018/1/10.
 */

public class Model implements IModel{

    private Presenter presenter;

    public Model(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void get(String baseurl, Map<String, String> map) {
        Flowable<Bean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).get(map);
        presenter.getData(flowable);
    }
}
