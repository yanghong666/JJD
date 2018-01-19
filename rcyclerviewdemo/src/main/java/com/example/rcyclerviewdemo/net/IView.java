package com.example.rcyclerviewdemo.net;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public interface IView {
    void success(Object data);
    void failed(Throwable e);
}