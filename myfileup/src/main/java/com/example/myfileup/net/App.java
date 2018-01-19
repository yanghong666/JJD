package com.example.myfileup.net;

import android.app.Application;

import com.example.myfileup.modlel.DaoMaster;
import com.example.myfileup.modlel.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by 杨洪 on 2018/1/12.
 */

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"test.db");
        Database database=helper.getWritableDb();
        daoSession=new DaoMaster(database).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
