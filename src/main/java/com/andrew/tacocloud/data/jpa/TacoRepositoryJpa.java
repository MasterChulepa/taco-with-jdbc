package com.andrew.tacocloud.data.jpa;

import com.andrew.tacocloud.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepositoryJpa extends CrudRepository<Taco, Long> {
}
