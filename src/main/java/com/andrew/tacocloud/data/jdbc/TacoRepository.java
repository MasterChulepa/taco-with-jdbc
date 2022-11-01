package com.andrew.tacocloud.data.jdbc;

import com.andrew.tacocloud.web.domains.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
