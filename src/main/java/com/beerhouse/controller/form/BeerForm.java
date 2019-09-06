package com.beerhouse.controller.form;

import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class BeerForm {

    @NotNull(message = "Please provide a name") @NotEmpty
    private String name;
    @NotNull(message = "Please provide a ingredient") @NotEmpty
    private String ingredients;
    @NotNull(message = "Please provide a Alcohol Content") @NotEmpty
    private String alcoholContent;
    private float price;
    @NotNull(message = "Please provide a category") @NotEmpty
    private String category;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(String alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Beer convert() {
        return new Beer(name, ingredients, alcoholContent, price, category);
    }

    public Beer update(int id, BeerRepository beerRepository) {
        Beer beer = beerRepository.getOne(id);
        beer.setName(this.name);
        beer.setIngredients(this.ingredients);
        beer.setAlcoholContent(this.alcoholContent);
        beer.setPrice(this.price);
        beer.setCategory(this.category);

        return beer;
    }
}
