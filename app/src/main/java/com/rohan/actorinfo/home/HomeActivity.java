package com.rohan.actorinfo.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.rohan.actorinfo.R;
import com.rohan.actorinfo.core.BaseActivity;
import com.rohan.actorinfo.databinding.HomeActivityBinding;
import com.rohan.actorinfo.home.model.HeroModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    private HomeViewModel viewModel;
    private HomeActivityBinding mBinding;
    private HomeListAdapter adapter;
    private List<HeroModel> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mBinding = DataBindingUtil.setContentView(this,R.layout.home_activity);

        initView();
        getFirstData();

    }

    private void initView(){
        if (list == null){
            list = new ArrayList<>();
        }
        adapter = new HomeListAdapter(this,list);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mBinding.recyclerView.setAdapter(adapter);
    }


    private void getFirstData(){
        mBinding.progress.pbrActivityHome.setVisibility(View.VISIBLE);
        viewModel.getHeroes().observe(this, new Observer<List<HeroModel>>() {
            @Override
            public void onChanged(@Nullable List<HeroModel> heroModels) {

                list.addAll(heroModels);
                adapter.notifyDataSetChanged();
                mBinding.progress.pbrActivityHome.setVisibility(View.GONE);
            }
        });
    }
}
