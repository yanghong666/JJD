package com.example.rcyclerviewdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public class MyAdapter extends PagerAdapter {

    private List<ImageView> ima = new ArrayList<>();

    public MyAdapter(List<ImageView> ima) {
        this.ima = ima;
    }

    @Override
    public int getCount() {
        return ima.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(ima.get(position));
        return ima.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(ima.get(position));
    }


}
