package com.example.ashut.mylivedata.Service;

/**
 * Created by ashut on 11/5/2018.
 */

import com.example.ashut.mylivedata.model.MyResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationServiceInterface {
    @GET("iss-pass.json")
    Observable<ServiceResponse> getMyResponse(@Query("lat") String latitude,
                                         @Query("lon") String longitude);
}
