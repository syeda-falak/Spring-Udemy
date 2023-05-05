package com.codingpractice.OrderService.Service;

import com.codingpractice.OrderService.Model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
