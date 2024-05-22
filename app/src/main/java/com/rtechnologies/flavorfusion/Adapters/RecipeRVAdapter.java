package com.rtechnologies.flavorfusion.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rtechnologies.flavorfusion.GenerateRecipeScreen;
import com.rtechnologies.flavorfusion.HomeScreen;
import com.rtechnologies.flavorfusion.Models.RecipeModel;
import com.rtechnologies.flavorfusion.R;
import com.rtechnologies.flavorfusion.RecipeDetailsScreen;

import java.util.ArrayList;
import java.util.List;

public class RecipeRVAdapter extends RecyclerView.Adapter<RecipeRVAdapter.MyViewHolder> {

    ArrayList<RecipeModel> recipeList;
    Context context;

    public RecipeRVAdapter(ArrayList<RecipeModel> recipeList, Context context){
        this.recipeList = recipeList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_recyclerview_design, parent,false);
        return new RecipeRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // setting data
        holder.recipeImage.setImageResource(recipeList.get(position).getRecipeImage());
        holder.heartImage.setImageResource(recipeList.get(position).getHeartImage());
        holder.starImage.setImageResource(recipeList.get(position).getStarImage());
        holder.recipeName.setText(recipeList.get(position).getRecipeName());
        holder.rating.setText(recipeList.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView recipeImage, heartImage,starImage;
        TextView recipeName, rating;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recipeImage = itemView.findViewById(R.id.iv_recipeImage);
            heartImage = itemView.findViewById(R.id.iv_heartImage);
            starImage = itemView.findViewById(R.id.iv_star);
            recipeName = itemView.findViewById(R.id.tv_recipeName);
            rating = itemView.findViewById(R.id.rating);

        }

    }
}
