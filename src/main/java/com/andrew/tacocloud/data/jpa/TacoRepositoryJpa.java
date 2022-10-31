package com.andrew.tacocloud.data.jpa;

import com.andrew.tacocloud.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepositoryJpa extends PagingAndSortingRepository<Taco, Long> {
}
