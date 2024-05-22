package com.rtechnologies.flavorfusion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rtechnologies.flavorfusion.Adapters.TagRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class GenerateRecipeScreen extends AppCompatActivity {

    private ImageView homeBtn, generateBtn, favBtn, backBtn;
    private EditText searchBar;
    private RecyclerView tagRecyclerView;
    private TagRVAdapter tagRVAdapter;
    private List<String> selectedTagsList;
    private TextView messageText;
    private ImageView addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_recipe_screen);

        // hooks
        homeBtn = findViewById(R.id.btn_home);
        generateBtn = findViewById(R.id.btn_generate);
        favBtn = findViewById(R.id.btn_fav);
        backBtn = findViewById(R.id.back_icon);

        searchBar = findViewById(R.id.searchBar);
        selectedTagsList = new ArrayList<>();
        messageText = findViewById(R.id.messageText);
        addButton = findViewById(R.id.addButton);

        // set recyclerview
        tagRecyclerView = findViewById(R.id.tagRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        tagRecyclerView.setLayoutManager(gridLayoutManager);
        tagRVAdapter = new TagRVAdapter(selectedTagsList);
        tagRecyclerView.setAdapter(tagRVAdapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredTag = searchBar.getText().toString().trim();
                if (!enteredTag.isEmpty()) {
                    tagRVAdapter.addTag(enteredTag);
                    searchBar.setText(""); // Clear the search bar
                }
            }
        });

        // Intents
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GenerateRecipeScreen.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GenerateRecipeScreen.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GenerateRecipeScreen.this, "You are on generate recipe Screen", Toast.LENGTH_SHORT).show();

            }
        });

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenerateRecipeScreen.this, FavouriteRecipeScreen.class);
                startActivity(intent);
            }
        });
    }
//    private void showAddedMessage(String tag) {
//        String message =  tag + " added!";
//        messageText.setText(message);
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                messageText.setText(""); // Clear the message
//            }
//        }, 1500); // Delay i
//    }
}