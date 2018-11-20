package com.example.ashut.mylivedata.dagger;

import com.example.ashut.mylivedata.model.MyResponse;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashut on 11/15/2018.
 */
@Module
public class ResponseModule {

    @Provides
    MyResponse providesMyResponse()
    {
        return new MyResponse();
    }

}
