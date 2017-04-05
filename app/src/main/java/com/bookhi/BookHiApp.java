package com.bookhi;

import android.app.Application;

import com.bookhi.di.component.AppComponent;
import com.bookhi.di.component.DaggerAppComponent;

/**
 * Created by Limingyu on 2017/4/5.
 */
public class BookHiApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().build();
    }
}
