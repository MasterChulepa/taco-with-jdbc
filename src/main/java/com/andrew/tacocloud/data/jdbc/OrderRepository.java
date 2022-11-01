package com.andrew.tacocloud.data.jdbc;

import com.andrew.tacocloud.web.domains.Order;

public interface OrderRepository {

    Order save(Order order);
}
