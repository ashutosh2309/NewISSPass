package com.example.ashut.mylivedata;

import android.app.Application;

import com.example.ashut.mylivedata.dagger.AppComponent;
import com.example.ashut.mylivedata.dagger.AppModule;
import com.example.ashut.mylivedata.dagger.DaggerAppComponent;

/**
 * Created by ashut on 11/15/2018.
 */

public class MyLiveDataApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);

    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
