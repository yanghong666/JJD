package com.example.rcyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rcyclerviewdemo.adapter.RVAdapter;
import com.example.rcyclerviewdemo.bean.GoodBeanns;
import com.example.rcyclerviewdemo.mvp.GoodsPresenter;
import com.example.rcyclerviewdemo.net.IView;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private static final String TAG = "MainActivity";
    private GoodsPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //初始化数据
        initData();
    }

    private void initData() {
        presenter = new GoodsPresenter();
        presenter.attachView(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("uri","homepage");
        presenter.getData("http://result.eolinker.com/",map);
    }

    @Override
    public void success(Object data) {
        GoodBeanns goodBeanns= (GoodBeanns) data;
        GoodBeanns.DataBean data1 = goodBeanns.getData();
        //轮播图
        List<GoodBeanns.DataBean.Ad1Bean> ad1 = data1.getAd1();
        //分类框
        List<GoodBeanns.DataBean.Ad5Bean> ad5 = data1.getAd5();
        //热门活动
        GoodBeanns.DataBean.ActivityInfoBean activityInfo = data1.getActivityInfo();
        List<GoodBeanns.DataBean.ActivityInfoBean.ActivityInfoListBean> infoList = activityInfo.getActivityInfoList();
        //热门专题
        List<GoodBeanns.DataBean.SubjectsBean> subjects = data1.getSubjects();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        RVAdapter rvAdapter = new RVAdapter(MainActivity.this, ad1,ad5,infoList,subjects);
        recyclerView.setAdapter(rvAdapter);
    }

    @Override
    public void failed(Throwable e) {
        Log.e(TAG, "failed: "+e.getMessage() );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detachView();
        }
    }
}