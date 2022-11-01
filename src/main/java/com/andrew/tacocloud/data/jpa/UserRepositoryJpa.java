package com.andrew.tacocloud.data.jpa;

import com.andrew.tacocloud.web.domains.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryJpa  extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
