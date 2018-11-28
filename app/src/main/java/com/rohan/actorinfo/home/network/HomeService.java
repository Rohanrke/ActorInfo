package com.rohan.actorinfo.home.network;


import com.rohan.actorinfo.home.model.HeroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeService {

    /**
     * @GET declares an HTTP GET request
     */
    @GET("marvel")
    Call<List<HeroModel>> getHeroList();
}
