package com.rtechnologies.flavorfusion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rtechnologies.flavorfusion.Models.RecipeModel;

import java.util.ArrayList;

public class FavouriteRecipeScreen extends AppCompatActivity {

    private ImageView homeBtn, generateBtn, favBtn, backBtn;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<RecipeModel> favouriteArrayList;
    FavouriteRVAdapter favouriteRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_recipe_screen);

        // hooks
        homeBtn = findViewById(R.id.btn_home);
        generateBtn = findViewById(R.id.btn_generate);
        favBtn = findViewById(R.id.btn_fav);
        backBtn = findViewById(R.id.back_icon);

        // Intents
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavouriteRecipeScreen.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FavouriteRecipeScreen.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FavouriteRecipeScreen.this, GenerateRecipeScreen.class);
                startActivity(intent);

            }
        });

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FavouriteRecipeScreen.this, "You are on Saved Recipe Screen", Toast.LENGTH_SHORT).show();
            }
        });

        initData();
        initRecyclerView();
    }

    private void initData() {

        favouriteArrayList = new ArrayList<>();
        favouriteArrayList.add(new FavouriteModel(R.drawable.dish2,R.drawable.filled_bookmark,R.drawable.star,"Chicken Handi","4.5 ratings"));
        favouriteArrayList.add(new FavouriteModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Chicken Hawaiian","4.5 ratings"));
        favouriteArrayList.add(new FavouriteModel(R.drawable.dish2,R.drawable.filled_bookmark,R.drawable.star,"Chicken Handi","4.5 ratings"));
        favouriteArrayList.add(new FavouriteModel(R.drawable.dish2,R.drawable.filled_bookmark,R.drawable.star,"Chicken Handi","4.5 ratings"));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.favourite_recylerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        favouriteRVAdapter = new FavouriteRVAdapter(favouriteArrayList,this);
        recyclerView.setAdapter(favouriteRVAdapter);
        favouriteRVAdapter.notifyDataSetChanged();

    }
}