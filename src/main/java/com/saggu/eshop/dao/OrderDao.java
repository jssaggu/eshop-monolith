package com.saggu.eshop.dao;

import com.saggu.eshop.dao.CustomerDao.CustomerDto;
import com.saggu.eshop.dao.ProductDao.ProductDto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.saggu.eshop.dao.CustomerDao.getCustomer;
import static com.saggu.eshop.dao.ProductDao.getProduct;
import static java.util.List.of;

public class OrderDao {

    static final Map<String, OrderDto> orders = Map.of(
            "O100", OrderDto.builder()
                    .orderId("O100")
                    .customer(getCustomer("C100").get())
                    .products(of(getProduct("P100").get())).build(),
            "O200", OrderDto.builder()
                    .orderId("O200")
                    .customer(getCustomer("C200").get())
                    .products(of(getProduct("P100").get(), getProduct("P200").get())).build(),
            "O300", OrderDto.builder()
                    .orderId("O300")
                    .customer(getCustomer("C300").get())
                    .products(of(getProduct("P200").get(), getProduct("P300").get())).build()
    );

    public static Optional<OrderDto> getOrder(String productId) {
        return Optional.ofNullable(orders.get(productId));
    }

    @Data
    @Builder
    @ToString
    public static class OrderDto {
        private String orderId;
        private CustomerDto customer;
        private List<ProductDto> products;
    }
}
