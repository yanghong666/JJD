package com.example.twoweek.model;

import com.example.twoweek.bean.DanSpBean;
import com.example.twoweek.bean.GwcBean;
import com.example.twoweek.bean.JgBean;
import com.example.twoweek.net.ApiService;
import com.example.twoweek.net.RetrofitUtils;
import com.example.twoweek.presenter.Presenter;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by 杨洪 on 2018/1/8.
 */

public class Model implements IModel {

    private Presenter presenter;

    public Model(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void get(String baseurl, Map<String, String> map) {
        Flowable<GwcBean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).get(map);
        presenter.getData(flowable);
    }
    //getdel
    @Override
    public void getdel(String baseurl, Map<String, String> map) {
        Flowable<GwcBean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).getdel(map);
        presenter.getData(flowable);
    }

    @Override
    public void getshowdan(String baseurl, Map<String, String> map) {

        Flowable<DanSpBean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).getshowdan(map);
      presenter.getData(flowable);
    }

    @Override
    public void getadd(String baseurl, Map<String, String> map) {
        Flowable<JgBean> flowable = RetrofitUtils.getInstance(baseurl).getretrofit().create(ApiService.class).getadd(map);
        presenter.getDataAdd(flowable);
    }


}
