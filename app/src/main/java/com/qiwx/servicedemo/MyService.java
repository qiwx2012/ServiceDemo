package com.qiwx.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author qiwx
 * @create 2019/4/2 11:16
 * @des
 **/
public class MyService extends Service {
    public static String TAG=MyService.class.getSimpleName();
    private MyBinder binder= new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"Create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
    class MyBinder extends Binder{
        public void startDownload(){
            Log.e(TAG,"startDownload===");
        }
        public int getProgress(){
            Log.e(TAG,"getProgress===");
            return 0;
        }
    }
}
