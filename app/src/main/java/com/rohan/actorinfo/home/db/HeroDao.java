package com.rohan.actorinfo.home.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rohan.actorinfo.home.model.HeroModel;

import java.util.List;


@Dao

public interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    HeroModel save(HeroModel user);

    @Query("SELECT * FROM hero")
    LiveData<List<HeroModel>> load();

    @Query("SELECT * FROM hero WHERE name = :name")
    LiveData<HeroModel> getHero(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<HeroModel> heroModel);
}
