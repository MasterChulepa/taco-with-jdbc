package com.andrew.tacocloud.web.api;


import com.andrew.tacocloud.web.api.models.TacoModel;
import com.andrew.tacocloud.web.api.models.TacoModelAssembler;
import com.andrew.tacocloud.web.domains.Taco;
import com.andrew.tacocloud.data.jpa.TacoRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoControllerApi {
    private final TacoRepositoryJpa tacoRepository;

    @Autowired
    public DesignTacoControllerApi(TacoRepositoryJpa tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping("/recent")
    public CollectionModel<TacoModel> recentTacos() {
        PageRequest pageRequest = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepository.findAll(pageRequest).getContent();
        CollectionModel<TacoModel> recentTacos = new TacoModelAssembler().toCollectionModel(tacos);
        recentTacos.add(
                linkTo(methodOn(DesignTacoControllerApi.class).recentTacos()) //URL is derived from the controller’s mappings,
                        .withRel("recents"));                                 // and absolutely no portion is hardcoded
        return recentTacos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        return optionalTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }
}
