package com.andrew.tacocloud.data.jpa;

import com.andrew.tacocloud.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepositoryJpa extends CrudRepository<Order, Long> {
}
