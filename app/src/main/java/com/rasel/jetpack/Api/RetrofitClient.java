package com.rasel.jetpack.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

   // private static final String BASE_URL = "https://simplifiedcoding.net/demos/";  //Used in the View Model Testing and Uri for downloading superhero name and their image
  //  private static final String BASE_URL = "https://api.stackexchange.com/2.2/";    //Used in the Paging testing and Uri for downloading huge list of data
    private static final String BASE_URL = "http://tradeaccount.com.bd/api/core/";
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized RetrofitClient getInstance(){

        if( retrofitClient==null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }
    public JsonPlaceHolderApi getApi(){
        return retrofit.create(JsonPlaceHolderApi.class);
    }
}
