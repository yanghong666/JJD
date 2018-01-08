package com.example.twoweek.presenter;

import com.example.twoweek.model.Model;
import com.example.twoweek.view.IView;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 杨洪 on 2018/1/8.
 */

public class Presenter implements BasePresenter {

    private IView iv;
    private DisposableSubscriber subscriber;
    private Model model;
    public Presenter(IView iv) {
        this.iv = iv;
    }

    @Override
    public void get(String baseurl,Map<String, String> map) {
        model = new Model(this);
        model.get(baseurl,map);
    }

    @Override
    public void getdel(String baseurl,Map<String, String> map) {
        model = new Model(this);
        model.getdel(baseurl,map);
    }

    @Override
    public void getshowdan(String baseurl, Map<String, String> map) {
        model = new Model(this);
        model.getshowdan(baseurl,map);


    }

    @Override
    public void getadd(String baseurl, Map<String, String> map) {
        model = new Model(this);
        model.getadd(baseurl,map);
    }


    public void getData(Flowable flowable){
                subscriber = (DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {
                        iv.onSuccess(o);
                       // iv.onSuccessadd(o);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iv.onFailed((Exception) t);
                       // iv.onFailedadd((Exception) t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public void getDataAdd(Flowable flowable){
        subscriber = (DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {

                         iv.onSuccessAdd(o);
                    }

                    @Override
                    public void onError(Throwable t) {

                         iv.onFailedAdd((Exception) t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }











    //防止内存泄漏
    public void detatch(){
        if (iv != null) {
            iv = null;
        }
        if(subscriber!=null){
            if(!subscriber.isDisposed()){
                subscriber.dispose();
            }
        }
    }

}
