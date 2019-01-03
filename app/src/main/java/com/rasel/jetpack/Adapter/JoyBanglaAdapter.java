package com.rasel.jetpack.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rasel.jetpack.Model.Hero;
import com.rasel.jetpack.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class JoyBanglaAdapter extends RecyclerView.Adapter<JoyBanglaAdapter.JoyBanglaViewHolder> {

    private static final String TAG = "App";

    private Context mCtx;
    private List<Hero> heroList;

    public JoyBanglaAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public JoyBanglaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.joy_bangla_item, parent, false);
        return new JoyBanglaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JoyBanglaViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: position value  "+position);
        Hero hero = heroList.get(position);
        //Log.d(TAG, "onBindViewHolder: Name: "+hero.getName());
       // Log.d(TAG, "onBindViewHolder: Url : "+hero.getImageurl());

        //Glide.with(mCtx).load(hero.getImageurl()).into(holder.imageView);
        Picasso.get().load(hero.getImageurl()).into(holder.imageView);
        holder.textView.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class JoyBanglaViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        private JoyBanglaViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}