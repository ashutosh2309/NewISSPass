package com.example.ashut.mylivedata.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ashut.mylivedata.BR;
import com.example.ashut.mylivedata.R;
import com.example.ashut.mylivedata.databinding.ListItem1Binding;
import com.example.ashut.mylivedata.model.MyResponse;

import java.util.List;

/**
 * Created by ashut on 11/19/2018.
 */

public class ListView1Adapter extends RecyclerView.Adapter<ListView1Adapter.MyViewHolder>{

    List<MyResponse> myListResponse;
    CompoundButton prevRadioButton;
    public class MyViewHolder extends RecyclerView.ViewHolder implements RadioGroupEventListener{
        public TextView title;


        public ListItem1Binding viewDataBinding;

        MyViewHolder(ListItem1Binding binding){
            super(binding.getRoot());
            this.viewDataBinding=binding;
        }

        public void bind(MyResponse obj) {
            viewDataBinding.setServerResponse(obj);
            viewDataBinding.setItemClickListener(this);
            viewDataBinding.executePendingBindings();
        }

        @Override
        public void onItemClickListener(CompoundButton radio, boolean isChecked) {
            Log.i("radio button id",""+isChecked);

            if(prevRadioButton == null){
                prevRadioButton = radio;
            }else {
                prevRadioButton.setChecked(false);
                prevRadioButton = radio;
            }

        }
    }

    public ListView1Adapter(List<MyResponse> myResponseList){
        myListResponse = myResponseList;
    }

    @Override
    public int getItemCount() {
        return myListResponse.size();
    }
    public interface RadioGroupEventListener {
        void  onItemClickListener(CompoundButton radio, boolean isChecked);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ListItem1Binding binding = DataBindingUtil.inflate(
                layoutInflater, R.layout.list_item1, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(myListResponse.get(position));
    }
}
