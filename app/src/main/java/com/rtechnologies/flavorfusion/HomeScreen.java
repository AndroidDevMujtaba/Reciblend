package com.rtechnologies.flavorfusion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rtechnologies.flavorfusion.Adapters.RecipeRVAdapter;
import com.rtechnologies.flavorfusion.Models.RecipeModel;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private ImageView homeBtn, generateBtn, favBtn;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<RecipeModel> recipeList;
    RecipeRVAdapter recipeRVAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // hooks
        homeBtn = findViewById(R.id.btn_home);
        generateBtn = findViewById(R.id.btn_generate);
        favBtn = findViewById(R.id.btn_fav);


        // Intent
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeScreen.this, "You are on Home Screen", Toast.LENGTH_SHORT).show();
            }
        });

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, GenerateRecipeScreen.class);
                startActivity(intent);
            }
        });

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, FavouriteRecipeScreen.class);
                startActivity(intent);
            }
        });



        initData();
        initRecyclerView();
    }

    private void initData() {

        recipeList = new ArrayList<>();
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Chicken Handi","4.5"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Chicken Wrap","4.1"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Fries","4.5"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Beef Kebab","4.9"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Pastry","4.7"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));
        recipeList.add(new RecipeModel(R.drawable.biryani,R.drawable.filled_bookmark,R.drawable.star,"Biryani","4.3"));



    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.home_recylerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recipeRVAdapter = new RecipeRVAdapter(recipeList,this);
        recyclerView.setAdapter(recipeRVAdapter);
        recipeRVAdapter.notifyDataSetChanged();

    }


}