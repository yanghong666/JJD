package com.example.twoweek.presenter;

import java.util.Map;

/**
 * Created by 杨洪 on 2018/1/8.
 */

public interface BasePresenter {

    void get(String baseurl,Map<String,String> map);

    void getdel(String baseurl,Map<String,String> map);


    void getshowdan(String baseurl,Map<String,String> map);


    void getadd(String baseurl,Map<String,String> map);


}
