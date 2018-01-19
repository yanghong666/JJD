package com.example.rcyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rcyclerviewdemo.R;
import com.example.rcyclerviewdemo.bean.GoodBeanns;
import com.example.rcyclerviewdemo.utils.MyImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杨洪 on 2018/1/11.
 */

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    //轮播图
    private List<GoodBeanns.DataBean.Ad1Bean> ad1;
    //分类框
    private List<GoodBeanns.DataBean.Ad5Bean> ad5;
    //热门活动
    private List<GoodBeanns.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfo;
    //热门专题
    private List<GoodBeanns.DataBean.SubjectsBean> subjects;

    public RVAdapter(Context context, List<GoodBeanns.DataBean.Ad1Bean> ad1, List<GoodBeanns.DataBean.Ad5Bean> ad5, List<GoodBeanns.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfo,List<GoodBeanns.DataBean.SubjectsBean> subjects) {
        this.context = context;
        this.ad1 = ad1;
        this.ad5 = ad5;
        this.activityInfo = activityInfo;
        this.subjects=subjects;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position==1){
            return 2;
        }else if (position==2){
            return 3;
        }else if (position==3){
            return 4;
        }else if (position==4){
            return 5;
        }else {
            return 6;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.banner_item, null);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType==2){
            View view = View.inflate(context, R.layout.feilei_item, null);
            ViewHolder2 holder = new ViewHolder2(view);
            return holder;
        }else if (viewType==3){
            View view = View.inflate(context, R.layout.text_item, null);
            ViewHolder3 holder = new ViewHolder3(view);
            return holder;
        }else if (viewType==4){
            View view = View.inflate(context, R.layout.hot_item, null);
            ViewHolder4 holder = new ViewHolder4(view);
            return holder;
        }else if (viewType==5){
            View view = View.inflate(context, R.layout.text_item, null);
            ViewHolder3 holder = new ViewHolder3(view);
            return holder;
        }else {
            View view = View.inflate(context, R.layout.zt_item, null);
            ViewHolder5 holder = new ViewHolder5(view);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder vh1 = (ViewHolder) holder;
            ArrayList<String> imageList = new ArrayList<>();
            for (int i=0;i<ad1.size();i++){
                GoodBeanns.DataBean.Ad1Bean ad1Bean = ad1.get(i);
                imageList.add(ad1Bean.getImage());
            }
            //设置图片加载器
            vh1.banne.setImageLoader(new MyImageLoader());
            //设置图片集合
            vh1.banne.setImages(imageList);
            //设置动画效果
            vh1.banne.setBannerAnimation(Transformer.DepthPage);
            //设置轮播时间
            vh1.banne.setDelayTime(3000);
            //banner设置方法全部调用完毕时最后调用
            vh1.banne.start();
        } else if (holder instanceof ViewHolder2) {
            ViewHolder2 vh2 = (ViewHolder2) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            vh2.recyclerView.setLayoutManager(manager);
            FeiLeiAdapter flAdapter = new FeiLeiAdapter(context,ad5);
            vh2.recyclerView.setAdapter(flAdapter);
        }else if (holder instanceof ViewHolder3){
            ViewHolder3 vh3= (ViewHolder3) holder;
            vh3.tvTitle.setText("热门活动");
        }else if (holder instanceof ViewHolder4){
            ViewHolder4 vh4= (ViewHolder4) holder;
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            vh4.recyclerView.setLayoutManager(manager);
            HotAdapter hotAdapter = new HotAdapter(context,activityInfo);
            vh4.recyclerView.setAdapter(hotAdapter);
        }else if (holder instanceof ViewHolder3){
            ViewHolder3 vh3= (ViewHolder3) holder;
            vh3.tvTitle.setText("热门专题");
        }else if (holder instanceof ViewHolder5){
            ArrayList<GoodBeanns.DataBean.SubjectsBean.GoodsListBeanX> list1 = new ArrayList<>();
            for (int i=0;i<subjects.size();i++){
                List<GoodBeanns.DataBean.SubjectsBean.GoodsListBeanX> list = subjects.get(i).getGoodsList();
                list1.addAll(list);
            }
            ViewHolder5 vh5= (ViewHolder5) holder;
            GridLayoutManager manager = new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
            vh5.recyclerView.setLayoutManager(manager);
            ZTAdapter ztAdapter = new ZTAdapter(context,list1);
            vh5.recyclerView.setAdapter(ztAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final Banner banne;

        public ViewHolder(View itemView) {
            super(itemView);
            banne = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public ViewHolder2(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview);
        }
    }
    class ViewHolder4 extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public ViewHolder4(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview);
        }
    }
    class ViewHolder5 extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public ViewHolder5(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerview);
        }
    }
    class ViewHolder3 extends RecyclerView.ViewHolder{

        private final TextView tvTitle;

        public ViewHolder3(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
