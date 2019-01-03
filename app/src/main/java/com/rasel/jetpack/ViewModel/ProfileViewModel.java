package com.rasel.jetpack.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.rasel.jetpack.Api.RetrofitClient;
import com.rasel.jetpack.Model.profileResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends ViewModel {
    private static final String TAG = "App";

    private MutableLiveData<profileResponse> profileInfo;

    public LiveData<profileResponse> getProfileInfo() {
        if (profileInfo == null) {
            profileInfo = new MutableLiveData<>();
            loadProfileInfo();
        }
        return profileInfo;
    }

    private void loadProfileInfo() {
        Call<profileResponse> call = RetrofitClient.getInstance().getApi().getProfileInfo();

        call.enqueue(new Callback<profileResponse>() {
            @Override
            public void onResponse(Call<profileResponse> call, Response<profileResponse> response) {
                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Code: " + response.code());
                    return;
                }
                profileInfo.setValue(response.body());
            }

            @Override
            public void onFailure(Call<profileResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void setNewProfileInfo(profileResponse info) {
        profileResponse response = profileInfo.getValue();
        response.setU_email(info.getU_email());
        response.setU_present_address(info.getU_present_address());

        profileInfo.setValue(response);

        Log.d(TAG, "setNewProfileInfo: email: " + profileInfo.getValue().getU_email());
    }
}
