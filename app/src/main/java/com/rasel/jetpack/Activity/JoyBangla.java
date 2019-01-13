package com.rasel.jetpack.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

