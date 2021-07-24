package com.saggu.eshop.dao;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;
import java.util.Optional;

public class CustomerDao {

    static final Map<String, CustomerDto> customers = Map.of(
            "C100", CustomerDto.builder().customerId("C100").customerName("User A").build(),
            "C200", CustomerDto.builder().customerId("C200").customerName("User B").build(),
            "C300", CustomerDto.builder().customerId("C300").customerName("User C").build(),
            "C400", CustomerDto.builder().customerId("C400").customerName("User D").build()
    );

    public static Optional<CustomerDto> getCustomer(String customerId) {
        return Optional.ofNullable(customers.get(customerId));
    }

    @Data
    @Builder
    @ToString
    public static class CustomerDto {
        private String customerId;
        private String customerName;
    }
}
