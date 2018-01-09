package com.example.myavigation;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView timetv;
    private TextView tvbtn;

    private int time = 5;


    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            if (time > 0) {
                time--;
                timetv.setText("倒计时：" + time);

                handler.sendEmptyMessageDelayed(0, 1000);

            } else {


                SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
                boolean flag = sharedPreferences.getBoolean("flag", false);

                if (flag) {


                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(intent);


                } else {

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);


                    //获取一个文件名为test、权限为private的xml文件的SharedPreferences对象


                    //得到SharedPreferences.Editor对象，并保存数据到该对象中
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("flag", true);

                    //保存key-value对到文件中
                    editor.commit();


                    finish();

                }


            }


        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();


        //给handler发送空消息
        handler.sendEmptyMessage(0);


    }

    private void initView() {
        timetv = (TextView) findViewById(R.id.timetv);
        tvbtn = (TextView) findViewById(R.id.tvbtn);

        tvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//移除handler
                handler.removeCallbacksAndMessages(null);
                //取sharedPreferences中的flag值
                SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
                boolean flag = sharedPreferences.getBoolean("flag", false);


                if (flag) {


                    Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(intent);
                    finish();

                } else {

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);


                    //更改sharedPreferences中的flag值
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("flag", true);

                    //提交
                    editor.commit();


                    finish();

                }


            }
        });


    }
}
