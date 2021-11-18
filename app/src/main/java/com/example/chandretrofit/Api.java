package com.example.chandretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://dummy.restapiexample.com/api/v1/employee/1/";
    @GET("marvel")
    Call<List<Result>> getsuperHeroes();
}
