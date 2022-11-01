package com.andrew.tacocloud.web.api;

import com.andrew.tacocloud.data.jpa.IngredientRepositoryJpa;
import com.andrew.tacocloud.web.domains.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientControllerApi {
    private final IngredientRepositoryJpa ingredientRepositoryJpa;

    @Autowired
    public IngredientControllerApi(IngredientRepositoryJpa ingredientRepositoryJpa) {
        this.ingredientRepositoryJpa = ingredientRepositoryJpa;
    }

    @GetMapping
    public Iterable<Ingredient> getAllIngredients(){
        return ingredientRepositoryJpa.findAll();
    }
}
