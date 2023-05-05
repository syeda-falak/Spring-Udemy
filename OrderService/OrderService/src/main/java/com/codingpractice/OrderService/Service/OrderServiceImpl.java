package com.codingpractice.OrderService.Service;

import com.codingpractice.OrderService.Entity.Order;
import com.codingpractice.OrderService.Model.OrderRequest;
import com.codingpractice.OrderService.Repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public long placeOrder(OrderRequest orderRequest) {
        // Order Entity -> save the data with status Order created
        //Product Service -> block Products (Reduce The Quantity)
        //Payment Service -> Payments -> Success -> COMPLETED , ELSE -> CANCELLED
        log.info("Placing order request"+ orderRequest);
        Order order = Order.builder()
                .amount(orderRequest.getAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .id(0).build();
        order=orderRepository.save(order);
        log.info("Order placed successfully with order id: "+order.getId());

        return order.getId();
    }
}
