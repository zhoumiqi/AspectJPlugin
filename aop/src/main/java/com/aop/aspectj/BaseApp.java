package com.aop.aspectj;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.Stack;

/**
 * 应用Application
 * Created by zmq on 2017/5/11.
 */

public class BaseApp extends Application implements Application.ActivityLifecycleCallbacks {
    private static BaseApp mApp;
    public Stack<Activity> store;

    public static BaseApp getApp() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        store = new Stack<>();
        registerActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        store.add(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        store.remove(activity);
    }

    /**
     * 获取当前的Activity
     *
     * @return Activity
     */
    public Activity getCurActivity() {
        return store.lastElement();
    }
}
