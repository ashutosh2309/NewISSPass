package com.example.ashut.mylivedata.Service;

/**
 * Created by ashut on 11/5/2018.
 */
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientProvider {

    protected BaseRequestInterceptor mBaseRequestInterceptor;
    private Retrofit retrofitClient = null;
    protected String mBaseUrl;
    public static final String BASE_URL = "http://api.open-notify.org/";
    /**
     * Method to choose if the default http headers will be used or the customised headers will be used in the HTTP request using interceptors
     */
    public ApiClientProvider(BaseRequestInterceptor mBaseRequestInterceptor) {

        mBaseUrl = BASE_URL;

        if (mBaseRequestInterceptor != null) {
            this.mBaseRequestInterceptor = mBaseRequestInterceptor;
        } else {
            this.mBaseRequestInterceptor = new BaseRequestInterceptor(null);
        }
    }

    /**
     * Method to get the Retrofit rest client object to make the HTTP Calls
     */
    public Retrofit getRestClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(mBaseRequestInterceptor);

        OkHttpClient okHttpClient = httpClient.build();

        if (retrofitClient == null) {
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(mBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofitClient;
    }

}
