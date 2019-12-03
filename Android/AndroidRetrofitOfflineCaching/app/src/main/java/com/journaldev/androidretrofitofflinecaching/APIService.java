package com.journaldev.androidretrofitofflinecaching;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {


    String BASE_URL = "https://api.chucknorris.io/jokes/";

    @GET("{path}")
    Call<Jokes> getRandomJoke(@Path("path") String path);
}

