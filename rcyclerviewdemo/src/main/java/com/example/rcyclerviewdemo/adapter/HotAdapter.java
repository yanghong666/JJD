package com.example.rcyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.rcyclerviewdemo.R;
import com.example.rcyclerviewdemo.bean.GoodBeanns;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder>{
    private Context context;
    private List<GoodBeanns.DataBean.ActivityInfoBean.ActivityInfoListBean> infoList;

    public HotAdapter(Context context, List<GoodBeanns.DataBean.ActivityInfoBean.ActivityInfoListBean> infoList) {
        this.context = context;
        this.infoList = infoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hot_item_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgLogo.setImageURI(infoList.get(position).getActivityImg());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView imgLogo;

        public ViewHolder(View itemView) {
            super(itemView);
            imgLogo = (SimpleDraweeView) itemView.findViewById(R.id.img_logo);
        }
    }
}
