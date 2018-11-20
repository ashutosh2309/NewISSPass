package com.example.ashut.mylivedata.Service;

/**
 * Created by ashut on 11/5/2018.
 */

import com.example.ashut.mylivedata.model.MyRequest;
import com.example.ashut.mylivedata.model.MyResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ServiceResponse implements Serializable{
    @SerializedName("message")
    private String message;
    @SerializedName("request")
    private MyRequest request;
    @SerializedName("response")
    private MyResponse[] response;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyResponse [] getResponse() {
        return response;
    }

    public void setResponse(MyResponse [] response) {
        this.response = response;
    }

    public MyRequest getRequest() {
        return request;
    }

    public void setRequest(MyRequest request) {
        this.request = request;
    }

}
