package com.example.loginandregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandregistration.bean.Bean;
import com.example.loginandregistration.presenter.Presenter;
import com.example.loginandregistration.view.IView;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements IView, View.OnClickListener {
    private Presenter presenter;
    private EditText ednum;
    private EditText edpwd;
    private Button loginbtn;
    private Button registraionbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();










//?mobile=15004595102&password=111111


    }




    @Override
    public void onSuccess(Object o) {

        if(o!=null)
        {

            Bean b = (Bean) o;
            Toast.makeText(this, "" + b.getMsg()+""+b.getData().getUsername()+""+b.getCode(), Toast.LENGTH_SHORT).show();

        }



    }

    @Override
    public void onFailed(Exception e) {
        Toast.makeText(this, "网络请求失败" , Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        ednum = (EditText) findViewById(R.id.ednum);
        edpwd = (EditText) findViewById(R.id.edpwd);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        registraionbtn = (Button) findViewById(R.id.registraionbtn);

        loginbtn.setOnClickListener(this);
        registraionbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginbtn:
                submit();
                String ednumString = ednum.getText().toString();
                String edpwdString = edpwd.getText().toString();
                Toast.makeText(this, ""+ednumString+"--"+edpwdString, Toast.LENGTH_SHORT).show();
                presenter = new Presenter(this);
                Map<String, String> map = new HashMap<>();
                map.put("mobile",ednumString);
                map.put("password",edpwdString);
//?mobile=15004595102&password=111111
                presenter.get("http://120.27.23.105/", map);

                break;
            case R.id.registraionbtn:
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                                startActivity(intent);



                break;
        }
    }




    public  void  submit()
    {
        String ednumString = ednum.getText().toString().trim();
        if (TextUtils.isEmpty(ednumString)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String edpwdString = edpwd.getText().toString().trim();
        if (TextUtils.isEmpty(edpwdString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }



    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detatch();
    }






}
