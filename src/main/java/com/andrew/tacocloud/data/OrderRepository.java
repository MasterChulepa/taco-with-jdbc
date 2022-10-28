package com.andrew.tacocloud.data;

import com.andrew.tacocloud.Order;

public interface OrderRepository {

    Order save(Order order);
}
