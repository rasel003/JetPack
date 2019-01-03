package com.rasel.jetpack.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rasel.jetpack.Model.profileResponse;
import com.rasel.jetpack.R;
import com.rasel.jetpack.ViewModel.ProfileViewModel;

public class Profile extends AppCompatActivity {

    TextView tvName, tvEmail, tvPassport, tvPresentAddress, tvPermanentAddress;
    ProfileViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPassport = findViewById(R.id.tvPassport);
        tvPresentAddress = findViewById(R.id.tvPresentAddress);
        tvPermanentAddress = findViewById(R.id.tvPermanentAddress);

        model = ViewModelProviders.of(this).get(ProfileViewModel.class);

        model.getProfileInfo().observe(this, new Observer<profileResponse>() {
            @Override
            public void onChanged(@Nullable profileResponse profileResponse) {
                if(profileResponse == null){
                    Log.d("App", "onChanged: Profile Responxe is null");
                    return;
                }

                tvName.setText(profileResponse.getU_name());
                tvEmail.setText(profileResponse.getU_email());
                tvPassport.setText(profileResponse.getU_passport());
                tvPresentAddress.setText(profileResponse.getU_present_address());
                tvPermanentAddress.setText(profileResponse.getU_permanent_address());
            }
        });
    }

    public void raselClicked(View view) {

        profileResponse profileResponse = new profileResponse();
        profileResponse.setU_email("rasel.00x@gmail.com");
        profileResponse.setU_present_address("Badda");
        model.setNewProfileInfo(profileResponse);
    }
}
