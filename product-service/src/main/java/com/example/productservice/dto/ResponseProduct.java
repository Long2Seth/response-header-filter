package com.example.productservice.dto;


import lombok.Builder;

@Builder
public record ResponseProduct(

        Long id,
        String name,
        String description,
        double price,
        int quantity
) {
}
