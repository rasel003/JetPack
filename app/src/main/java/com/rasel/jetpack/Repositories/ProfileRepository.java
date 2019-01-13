package com.rasel.jetpack.Repositories;

import android.util.Log;

import com.rasel.jetpack.Api.RetrofitClient;
import com.rasel.jetpack.Model.ProfileResponse;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    private static final String TAG = "App";
    private static ProfileRepository instance;
    private MutableLiveData<ProfileResponse> profileInfo;

    public static ProfileRepository getInstance() {
        if (instance == null) {
            instance = new ProfileRepository();
        }
        return instance;
    }

    public MutableLiveData<ProfileResponse> getProfileInfo() {
        profileInfo = new MutableLiveData<>();

        Call<ProfileResponse> call = RetrofitClient.getInstance().getApi().getProfileInfo();

        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Code: " + response.code());
                    return;
                }
                if (response.body() != null) {
                    profileInfo.setValue(response.body());
                } else {
                    Log.d(TAG, "onResponse: response body is null");
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return profileInfo;
    }
}
