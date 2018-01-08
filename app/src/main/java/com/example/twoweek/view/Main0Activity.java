package com.example.twoweek.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.twoweek.R;

import com.example.twoweek.bean.JgBean;
import com.example.twoweek.presenter.Presenter;

import com.example.twoweek.bean.DanSpBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main0Activity extends AppCompatActivity implements IView {

    @BindView(R.id.img)
    SimpleDraweeView img;
    @BindView(R.id.little)
    TextView little;
    @BindView(R.id.yjprice)
    TextView yjprice;
    @BindView(R.id.dzprice)
    TextView dzprice;
    @BindView(R.id.gwcbtn)
    Button gwcbtn;
    @BindView(R.id.addbtn)
    Button addbtn;
    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        ButterKnife.bind(this);

        HashMap<String, String> map = new HashMap<>();
        map.put("pid", 64+"");
        presenter = new Presenter(this);
        presenter.getshowdan("https://www.zhaoapi.cn/",map);



        //加删除线
        yjprice.setPaintFlags(yjprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    // 跳转购物车
    public void gwcbtn(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    //加入购物车

    public void jrgwc(View view) {


        HashMap<String, String> map = new HashMap<>();
        map.put("pid", 64+"");
        map.put("uid", 3416 + "");

        presenter.getadd("http://120.27.23.105/",map);

    }

    @Override
    public void onSuccess(Object o) {

        if(o!=null)
        {
            DanSpBean danSpBean= (DanSpBean) o;
            DanSpBean.DataBean data = danSpBean.getData();
            String[] split = data.getImages().split("\\|");
            dzprice.setText("特价：" + data.getBargainPrice() + "");
            yjprice.setText("原价：" + data.getPrice() + "");
            little.setText(data.getTitle());
            Glide.with(this).load(split[0]).into(img);


        }



    }

    @Override
    public void onFailed(Exception e) {




    }

    @Override
    public void onSuccessAdd(Object o) {

        if(o!=null)
        {
            JgBean jgBean= (JgBean) o;

            Toast.makeText(this, ""+ jgBean.getMsg(), Toast.LENGTH_SHORT).show();

        }



    }

    @Override
    public void onFailedAdd(Exception e) {
        Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
    }



}
