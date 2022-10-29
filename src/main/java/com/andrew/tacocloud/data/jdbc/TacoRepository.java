package com.andrew.tacocloud.data.jdbc;

import com.andrew.tacocloud.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
