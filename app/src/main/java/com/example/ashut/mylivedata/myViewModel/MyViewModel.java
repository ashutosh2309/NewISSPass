package com.example.ashut.mylivedata.myViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.ashut.mylivedata.Service.GetDataService;
import com.example.ashut.mylivedata.Service.ServiceResponse;
import com.example.ashut.mylivedata.model.MyResponse;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
/**
 * Created by ashut on 11/5/2018.
 */

public class MyViewModel extends ViewModel {

    private final MutableLiveData<ServiceResponse> myResponseData = new MutableLiveData<>();

    private GetDataService getDataService;

    private final CompositeDisposable disposables = new CompositeDisposable();

    public MutableLiveData<ServiceResponse> serverResponse() {
        return myResponseData;
    }

    public MyViewModel() {

    }

    public void hitLocationServer(String lat, String longitude){
        disposables.add(new GetDataService().getDatafromService(lat,longitude).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        result -> myResponseData.setValue(result)
                ));
    }
}
