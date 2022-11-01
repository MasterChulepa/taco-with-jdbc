package com.andrew.tacocloud.web.api.models;

import com.andrew.tacocloud.web.api.IngredientControllerApi;
import com.andrew.tacocloud.web.domains.Ingredient;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientModel> {
    public IngredientResourceAssembler() {
        super(IngredientControllerApi.class, IngredientModel.class);
    }

    @Override
    public IngredientModel toModel(Ingredient entity) {
        return createModelWithId(entity.getId(), entity);
    }

    @Override
    protected IngredientModel instantiateModel(Ingredient entity) {
        return new IngredientModel(entity);
    }
}
