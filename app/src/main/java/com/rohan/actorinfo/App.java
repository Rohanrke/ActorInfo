package com.rohan.actorinfo;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.rohan.actorinfo.home.db.HeroDatabase;

public class App extends Application {

    private HeroDatabase database;

    private static  App INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        database = Room.databaseBuilder(getApplicationContext(),
                HeroDatabase.class, "database-name").allowMainThreadQueries().build();

    }

    public static App getInstance(){
        return INSTANCE;
    }


    public HeroDatabase getDatabase(){
        return database;
    }
}
