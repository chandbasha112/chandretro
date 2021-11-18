package com.example.chandretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {

    private static Retrofitclient instance = null;
    private Api myApi;

    private Retrofitclient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized Retrofitclient getInstance() {
        if (instance == null) {
            instance = new Retrofitclient();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }
}
