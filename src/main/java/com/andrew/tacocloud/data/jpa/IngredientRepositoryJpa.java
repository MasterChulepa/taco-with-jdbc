package com.andrew.tacocloud.data.jpa;

import com.andrew.tacocloud.web.domains.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepositoryJpa extends CrudRepository<Ingredient, String> {
}
