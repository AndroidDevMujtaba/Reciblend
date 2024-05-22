package com.rtechnologies.flavorfusion.Models;

public class RecipeModel {
    private int recipeImage;
    private int heartImage;
    private int starImage;
    private String recipeName;
    private String rating;

    public RecipeModel(int recipeImage, int heartImage, int starImage, String recipeName, String rating) {
        this.recipeImage = recipeImage;
        this.heartImage = heartImage;
        this.starImage = starImage;
        this.recipeName = recipeName;
        this.rating = rating;
    }

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }

    public int getHeartImage() {
        return heartImage;
    }

    public void setHeartImage(int heartImage) {
        this.heartImage = heartImage;
    }

    public int getStarImage() {
        return starImage;
    }

    public void setStarImage(int starImage) {
        this.starImage = starImage;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
