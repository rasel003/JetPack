package com.rasel.jetpack.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Log;

import com.rasel.jetpack.Api.RetrofitClient;
import com.rasel.jetpack.Model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroViewModel extends ViewModel {
    private static final String TAG = "App";

    private MutableLiveData<List<Hero>> heroList;

    public MutableLiveData<List<Hero>> getHeroes() {

        if (heroList == null) {
            heroList = new MutableLiveData<>();
            loadHeroes();
        }
        return heroList;
    }
    private void loadHeroes() {

        Call<List<Hero>> call = RetrofitClient.getInstance().getApi().getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Code: " + response.code());
                    return;
                }
                heroList.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}