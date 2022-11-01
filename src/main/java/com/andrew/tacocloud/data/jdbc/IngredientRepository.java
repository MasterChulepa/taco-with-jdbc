package com.andrew.tacocloud.data.jdbc;

import com.andrew.tacocloud.web.domains.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);

}
