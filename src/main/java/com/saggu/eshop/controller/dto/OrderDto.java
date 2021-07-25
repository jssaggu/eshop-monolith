package com.saggu.eshop.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class OrderDto {
    private String orderId;
    private CustomerDto customer;
    private List<ProductDto> products;
}