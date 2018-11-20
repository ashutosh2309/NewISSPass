package com.example.ashut.mylivedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ashut.mylivedata.Service.ServiceResponse;
import com.example.ashut.mylivedata.adapters.ListView1Adapter;
import com.example.ashut.mylivedata.databinding.ActivityMainBinding;
import com.example.ashut.mylivedata.model.MyResponse;
import com.example.ashut.mylivedata.myViewModel.MyViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {


    @Inject
    Context context;

    @Inject
    MyResponse myResponse;
    MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ((MyLiveDataApplication)getApplication()).getAppComponent().inject(this);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.serverResponse().observe(this, new Observer<ServiceResponse>() {
            @Override
            public void onChanged(@Nullable ServiceResponse myResponse) {
               myResponse.getResponse();
                binding.listview1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                binding.listview1.setAdapter(new ListView1Adapter(Arrays.asList(myResponse.getResponse())));
            }
        });
        myViewModel.hitLocationServer("56.66644", "45.55564");
    }
}
