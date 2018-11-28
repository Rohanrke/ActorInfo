package com.rohan.actorinfo.core;


import com.rohan.actorinfo.home.network.HomeService;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import okhttp3.Interceptor;
import okhttp3.Request;

import retrofit2.converter.jackson.JacksonConverterFactory;

public class ConnectionFactory {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl("https://simplifiedcoding.net/demos/")
            .addConverterFactory(JacksonConverterFactory.create());


    public static HomeService getHttpConnection() {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .build();
                return chain.proceed(request);
            }
        });


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(logging);


        Retrofit retrofit = retrofitBuilder.client(httpClient.build()).build();

        return retrofit.create(HomeService.class);
    }

}
