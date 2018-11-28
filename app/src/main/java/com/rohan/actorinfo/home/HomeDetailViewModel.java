package com.rohan.actorinfo.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.rohan.actorinfo.home.model.HeroModel;
import com.rohan.actorinfo.home.repo.HomeRepo;


public class HomeDetailViewModel extends ViewModel {

    private LiveData<HeroModel> data;
    private HomeRepo repo = new HomeRepo();

    public LiveData<HeroModel> getData(int id) {
        if (this.data == null) {
            data = repo.getHero(id);
        }
        return data;
    }



}
