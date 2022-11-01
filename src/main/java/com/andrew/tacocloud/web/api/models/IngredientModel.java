package com.andrew.tacocloud.web.api.models;

import com.andrew.tacocloud.web.domains.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

public class IngredientModel extends RepresentationModel<IngredientModel> {
    @Getter
    private final String name;
    @Getter
    private final Ingredient.Type type;

    public IngredientModel(Ingredient ingredient){
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}
