package com.beerhouse.controller.dto;

import com.beerhouse.model.Beer;

public class BeerDto {
    private int id;
    private String name;
    private String ingredients;
    private String alcoholContent;
    private float price;
    private String category;

    public BeerDto(Beer beer){
        this.id = beer.getId();
        this.name = beer.getName();
        this.ingredients = beer.getIngredients();
        this.alcoholContent = beer.getAlcoholContent();
        this.price = beer.getPrice();
        this.category = beer.getCategory();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getAlcoholContent() {
        return alcoholContent;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
