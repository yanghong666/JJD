package com.example.loginandregistration.presenter;

import com.example.loginandregistration.model.Model;
import com.example.loginandregistration.view.IView;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 杨洪 on 2018/1/10.
 */

public class Presenter implements BasePresenter{

    private IView iv;
    private DisposableSubscriber subscriber;

    public Presenter(IView iv) {
        this.iv = iv;
    }

    @Override
    public void get(String baseurl,Map<String, String> map) {
        Model model = new Model(this);
        model.get(baseurl,map);
    }

    public void getData(Flowable flowable){
        subscriber = (DisposableSubscriber) flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {

                        iv.onSuccess(o);
                    }

                    @Override
                    public void onError(Throwable t) {

                        iv.onFailed((Exception) t);
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
