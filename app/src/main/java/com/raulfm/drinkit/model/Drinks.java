package com.raulfm.drinkit.model;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    private List<Drink> drinks;

    public Drinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public Drinks() {
        this.drinks = new ArrayList<>();
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public Drink primeiroDrink() {
        return drinks.get(0);
    }
}
