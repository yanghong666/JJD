package com.example.rcyclerviewdemo.net;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public interface CallBack {
    void onSuccess(Object o);
    void onFailed(Throwable t);
}
