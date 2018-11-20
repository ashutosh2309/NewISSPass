package com.example.ashut.mylivedata.Service;


import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ashutosh Singh on 11/29/2017.
 * The interceptor class to intercept the default headers in the HTTP request
 */

public class BaseRequestInterceptor implements Interceptor {

    private final static String TAG = BaseRequestInterceptor.class.getName();

    private HashMap<String, String> requestHeaderValues;

    public BaseRequestInterceptor(HashMap<String, String> headerValues) {
        requestHeaderValues = headerValues;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        /** Will be called for every request. chain will include the request data, call chain.proceed() to continue with the HTTP request.*/

        Request original = chain.request();

        Request.Builder newBuilder = original.newBuilder();

        if (requestHeaderValues != null && requestHeaderValues.size() > 0) {
            final Set<String> keys = requestHeaderValues.keySet();
            for (final String key : keys) {
                newBuilder.addHeader(key, requestHeaderValues.get(key));
            }
            requestHeaderValues.clear();
        }
        // Customize the request
        Request request = newBuilder
                //TODO check needed default headers
                .header(ISSPassConstants.CONTENT_TYPE, ISSPassConstants.APPLICATION_JSON)
                .header(ISSPassConstants.ACCEPT, ISSPassConstants.APPLICATION_JSON)
                .header(ISSPassConstants.CACHE_CONTROL, ISSPassConstants.NO_STORE)
                .method(original.method(), original.body())
                .build();

        Response response = chain.proceed(request);
        // Customize or return the response
        return response;
    }
    public class ISSPassConstants {



        public static final String CONTENT_TYPE = "Content-Type";

        public static final String APPLICATION_JSON = "application/json";

        public static final String ACCEPT = "Accept";

        public static final String CACHE_CONTROL = "Cache-Control";

        public static final String NO_STORE ="no-store";

        public static final long MIN_TIME_BTW_UPDATES =10000;

        public static final float MIN_DISTANCE_CHANGEFOR_UPDATE =10000;



    }
}
