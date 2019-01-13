package com.rasel.jetpack.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Log;

import com.rasel.jetpack.Model.ProfileResponse;
import com.rasel.jetpack.Repositories.ProfileRepository;

public class ProfileViewModel extends ViewModel {
    private static final String TAG = "App";

    private MutableLiveData<ProfileResponse> profileInfo;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();
    private ProfileRepository profileRepository;

    public LiveData<ProfileResponse> getProfileInfo() {
        return profileInfo;
    }
    public void init(){
        if(profileInfo !=null){
            return;
        }
        profileRepository = ProfileRepository.getInstance();
        profileInfo = profileRepository.getProfileInfo();
    }

    public void setNewProfileInfo(ProfileResponse info) {
        isUpdating.setValue(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProfileResponse response = profileInfo.getValue();
        response.setU_email(info.getU_email());
        response.setU_present_address(info.getU_present_address());

        profileInfo.setValue(response);
        isUpdating.setValue(false);
    }
    public LiveData<Boolean> getIsUpdating(){
        return isUpdating;
    }
}
