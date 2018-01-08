package com.example.twoweek.view;

/**
 * Created by 杨洪 on 2018/1/8.
 */

public interface IView {

    void onSuccess(Object o);
    void onFailed(Exception e);

    void onSuccessAdd(Object o);
    void onFailedAdd(Exception e);


}