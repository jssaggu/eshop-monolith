package com.saggu.eshop.controller;

import com.saggu.eshop.controller.dto.OrderDto;
import com.saggu.eshop.dao.OrderDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class Order {

    @GetMapping(value = "/orders/{orderId}")
    public ResponseEntity<OrderDto> productById(@PathVariable("orderId") String orderId) {
        Optional<OrderDto> order = OrderDao.getOrder(orderId);

        if (order.isPresent()) {
            return ok(order.get());
        }

        return notFound().build();
    }
}
