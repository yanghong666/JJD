package com.example.rcyclerviewdemo.mvp;

import com.example.rcyclerviewdemo.net.CallBack;
import com.example.rcyclerviewdemo.net.IView;
import com.example.rcyclerviewdemo.utils.RetrofitUtils;

import java.util.Map;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public class GoodsPresenter {
    private IView iView;
    public GoodsPresenter(){

    }
    public void attachView(IView iView){
        this.iView=iView;
    }
    public void getData(String url, Map<String,String> map){
        RetrofitUtils.getInstance().getNews(url, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                iView.success(o);
            }

            @Override
            public void onFailed(Throwable t) {
                iView.failed(t);
            }
        },map);
    }
    public void detachView(){
        if (iView!=null){
            iView=null;
        }
    }
}
