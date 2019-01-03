package com.rasel.jetpack.Activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rasel.jetpack.Adapter.JoyBanglaAdapter;
import com.rasel.jetpack.Model.Hero;
import com.rasel.jetpack.ViewModel.HeroViewModel;
import com.rasel.jetpack.R;

import java.util.List;

public class JoyBangla extends AppCompatActivity {

    RecyclerView recyclerView;
    JoyBanglaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_bangla);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       HeroViewModel model = ViewModelProviders.of(this).get(HeroViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new JoyBanglaAdapter(JoyBangla.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}

