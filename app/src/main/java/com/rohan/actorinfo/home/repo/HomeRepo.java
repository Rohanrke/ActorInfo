package com.rohan.actorinfo.home.repo;

import android.arch.lifecycle.LiveData;

import com.rohan.actorinfo.App;
import com.rohan.actorinfo.core.BaseRepo;
import com.rohan.actorinfo.home.db.HeroDao;
import com.rohan.actorinfo.home.model.HeroModel;
import com.rohan.actorinfo.home.network.HomeServiceImpl;

import java.util.List;

public class HomeRepo implements BaseRepo {

    HeroDao heroDao;

    /**
     * // Dagger can be used for dependency injection for HeroDao
     *
     */
     public HomeRepo(){

         heroDao = App.getInstance().getDatabase().heroDao();
     }

    /**
     *    Can user Dagger for HomeServiceImpl instance
     *
     */
    private HomeServiceImpl service = new HomeServiceImpl();

     public LiveData<List<HeroModel>> getHeroData(){

         service.getHeroList();
         return heroDao.load();
     }


    public LiveData<HeroModel> getHero(int id){

        return heroDao.getHero(id);
    }


}
