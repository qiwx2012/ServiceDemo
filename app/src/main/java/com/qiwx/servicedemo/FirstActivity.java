package com.qiwx.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author qiwx
 * @create 2019/4/2 11:27
 * @des
 **/
public class FirstActivity extends AppCompatActivity {
    MyService.MyBinder binder;
    private static String TAG=FirstActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        //绑定
        Intent bindIntent=new Intent(this,MyService.class);
        bindService(bindIntent,connection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑 多次点击解绑会异常
        unbindService(connection);
    }

    //匿名内部类：服务连接对象
    private ServiceConnection connection=new ServiceConnection() {
        //绑定成功 回调此方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG,"服务绑定成功"+name.getClassName());
            binder=(MyService.MyBinder)service;
            binder.startDownload();
            binder.getProgress();
        }
        //当异常终止时会调用。注意解除服务时不会调用
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG,"服务异常终止"+name.getClassName());
        }
    };
}
