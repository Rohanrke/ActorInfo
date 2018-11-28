package com.rohan.actorinfo.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
//import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.rohan.actorinfo.R;
import com.rohan.actorinfo.constants.Constants;
import com.rohan.actorinfo.core.BaseActivity;
//import com.rohan.actorinfo.databinding.ActivityHomeBinding;
import com.rohan.actorinfo.home.model.HeroModel;
import com.squareup.picasso.Picasso;

import java.net.URI;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class HomeDetailActivity extends BaseActivity {

  //  ActivityHomeBinding mBinding;
    private HomeDetailViewModel viewModel;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(HomeDetailViewModel.class);
        setContentView(R.layout.activity_home);
     //   mBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        imageView = findViewById(R.id.image_main);
        setData(getIntent().getIntExtra(Constants.ITEM_ID,0));


    }

    private void setData(int id){

         viewModel.getData(id).observe(this, new Observer<HeroModel>() {
            @Override
            public void onChanged(@Nullable HeroModel heroModel) {
                Picasso.get()
                        .load(heroModel.getImageurl())
                        .transform(new CropCircleTransformation())
                        .into(imageView);
            }
        });

    }
}
