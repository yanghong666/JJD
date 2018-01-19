package com.example.rcyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rcyclerviewdemo.R;
import com.example.rcyclerviewdemo.bean.GoodBeanns;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public class ZTAdapter extends RecyclerView.Adapter<ZTAdapter.ViewHolder>{
    private Context context;
    private ArrayList<GoodBeanns.DataBean.SubjectsBean.GoodsListBeanX> list1;

    public ZTAdapter(Context context, ArrayList<GoodBeanns.DataBean.SubjectsBean.GoodsListBeanX> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.zt_item_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgLogo.setImageURI(list1.get(position).getGoodsImage());
        holder.tvTitle.setText(list1.get(position).getGoodsName());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView imgLogo;
        private final TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            imgLogo = (SimpleDraweeView) itemView.findViewById(R.id.img_logo);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
