package com.example.twoweek.model;

import java.util.Map;

/**
 * Created by 杨洪 on 2018/1/8.
 */

public interface IModel {
    void get(String baseurl,Map<String,String> map);

    void getdel(String baseurl,Map<String,String> map);


    void getshowdan(String baseurl,Map<String,String> map);


    void getadd(String baseurl,Map<String,String> map);


}