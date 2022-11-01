package com.andrew.tacocloud.web;


import com.andrew.tacocloud.web.domains.Ingredient;
import com.andrew.tacocloud.web.domains.Ingredient.Type;
import com.andrew.tacocloud.web.domains.Order;
import com.andrew.tacocloud.web.domains.Taco;
import com.andrew.tacocloud.data.jpa.IngredientRepositoryJpa;
import com.andrew.tacocloud.data.jpa.TacoRepositoryJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
    public static final String DESIGN_VIEW_NAME = "design";
    @ModelAttribute("order")
    public Order order(){
        return new Order();
    }
    @ModelAttribute("design")
    public Taco taco(){
        return new Taco();
    }

    private final IngredientRepositoryJpa ingredientRepository;
    private final TacoRepositoryJpa tacoRepository;

    @Autowired
    public DesignTacoController(IngredientRepositoryJpa ingredientRepository,
                                TacoRepositoryJpa tacoRepository){
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }


    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream().filter(ingredient -> ingredient.getType().equals(type)).toArray());
        }
        model.addAttribute("design", new Taco());
        return DESIGN_VIEW_NAME;
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors,
                                @ModelAttribute("order") Order order){
        if(errors.hasErrors()){
            return DESIGN_VIEW_NAME;
        }

        Taco savedTaco =  tacoRepository.save(design);
        order.addDesign(savedTaco);
        return "redirect:/orders/current";
    }

}
