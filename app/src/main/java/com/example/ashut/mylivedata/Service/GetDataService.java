package com.example.ashut.mylivedata.Service;

import android.arch.lifecycle.MutableLiveData;

import com.example.ashut.mylivedata.model.MyResponse;

/**
 * Created by ashut on 11/5/2018.
 */
import java.io.IOException;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataService  {

    MutableLiveData<ServiceResponse> myResponseLiveData;
    public GetDataService() {
        myResponseLiveData = new MutableLiveData<>();
    }
    /**
     * Method for calling the rest api and feting the data
     */

    public Observable<ServiceResponse> getDatafromService(String latitude, String longitude) {
        LocationServiceInterface apiService = new ApiClientProvider(null).getRestClient().create(LocationServiceInterface.class);
        return apiService.getMyResponse(latitude,longitude);
    }

}
