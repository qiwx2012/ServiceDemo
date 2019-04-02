package com.qiwx.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;

/**
 * @author qiwx
 * @create 2019/4/2 11:32
 * @des 可以启动多次，每个耗时操作会以工作队列的方式在IntentService的
 * onHandleIntent回调中依次执行，
 * IntentService执行完后不需要用户手动停止 会自动destory
 **/
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public static String TAG=MyIntentService.class.getSimpleName();
    public MyIntentService(String name) {
        super(name);
    }
    public MyIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        Log.e(TAG,"onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand( Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG,"是否是主线程："+ (Looper.getMainLooper().getThread()==Thread.currentThread())+"");
        if(intent!=null){
            for(int i=0;i<3;i++){
                //打印当前线程Id
                Log.e(TAG,"当前线程名："+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
}
