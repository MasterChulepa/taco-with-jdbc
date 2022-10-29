package com.andrew.tacocloud.data.jdbc;

import com.andrew.tacocloud.Order;

public interface OrderRepository {

    Order save(Order order);
}
