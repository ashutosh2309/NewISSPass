package com.example.ashut.mylivedata.dagger;

import com.example.ashut.mylivedata.MainActivity;
import com.example.ashut.mylivedata.MyLiveDataApplication;
import com.example.ashut.mylivedata.model.MyResponse;

import dagger.Component;
import dagger.Module;

/**
 * Created by ashut on 11/15/2018.
 */
@Component (modules={AppModule.class,ResponseModule.class})
public interface AppComponent {

    void inject(MyLiveDataApplication myLiveDataApplication);
    void inject(MainActivity mainActivity);
}
