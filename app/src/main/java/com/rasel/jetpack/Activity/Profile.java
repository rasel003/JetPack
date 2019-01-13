package com.rasel.jetpack.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rasel.jetpack.Api.RetrofitClient;
import com.rasel.jetpack.Model.ProfileResponse;
import com.rasel.jetpack.R;
import com.rasel.jetpack.ViewModel.ProfileViewModel;

public class Profile extends AppCompatActivity {

    TextView tvName, tvEmail, tvPassport, tvPresentAddress, tvPermanentAddress;
    ProfileViewModel model;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPassport = findViewById(R.id.tvPassport);
        tvPresentAddress = findViewById(R.id.tvPresentAddress);
        tvPermanentAddress = findViewById(R.id.tvPermanentAddress);

        progressBar = findViewById(R.id.progressBar);

        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().getResult("32DFCFD@#&DSFDSFSDF!L@?hh7@32DF");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("rsl", "onResponse: rasel : --"+response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        /*model = ViewModelProviders.of(this).get(ProfileViewModel.class);
        model.init();

        model.getProfileInfo().observe(this, new Observer<ProfileResponse>() {
            @Override
            public void onChanged(@Nullable ProfileResponse ProfileResponse) {
                if(ProfileResponse == null){
                    Log.d("App", "onChanged: Profile Responxe is null");
                    return;
                }

                tvName.setText(ProfileResponse.getU_name());
                tvEmail.setText(ProfileResponse.getU_email());
                tvPassport.setText(ProfileResponse.getU_passport());
                tvPresentAddress.setText(ProfileResponse.getU_present_address());
                tvPermanentAddress.setText(ProfileResponse.getU_permanent_address());
            }
        });
        model.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
            }
        });*/
    }

    public void raselClicked(View view) {

        ProfileResponse ProfileResponse = new ProfileResponse();
        ProfileResponse.setU_email("rasel.00x@gmail.com");
        ProfileResponse.setU_present_address("Badda");
        model.setNewProfileInfo(ProfileResponse);
    }
}
