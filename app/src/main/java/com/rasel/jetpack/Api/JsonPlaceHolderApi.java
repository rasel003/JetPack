package com.rasel.jetpack.Api;

import com.rasel.jetpack.Model.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("marvel")
    Call<List<Hero>> getHeroes();

    @GET("answers")
    Call<StackApiResponse> getAnswers(
            @Query("page") int page,
            @Query("pagesize") int size,
            @Query("site") String site
    );
    @GET("userDetails/10")
    Call<profileResponse> getProfileInfo();
}