package com.example.ashut.mylivedata.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashut on 11/15/2018.
 */
@Module
public class AppModule {
    Context appContext;
    public AppModule(Context context){
       appContext = context;
    }
    @Provides
    Context providesContext(){
        return appContext;
    }

}
