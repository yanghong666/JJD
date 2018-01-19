package com.example.rcyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rcyclerviewdemo.R;
import com.example.rcyclerviewdemo.bean.GoodBeanns;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public class FeiLeiAdapter extends RecyclerView.Adapter<FeiLeiAdapter.ViewHolder>{
    private Context context;
    private List<GoodBeanns.DataBean.Ad5Bean> ad5;

    public FeiLeiAdapter(Context context, List<GoodBeanns.DataBean.Ad5Bean> ad5) {
        this.context = context;
        this.ad5 = ad5;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.feilei_item_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imgLogo.setImageURI(ad5.get(position).getImage());
        holder.tvTitle.setText(ad5.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return ad5.size();
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

