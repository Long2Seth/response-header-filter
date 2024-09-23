package com.example.productservice.dto;

public record RequestProduct (
    String name,
    String description,
    double price,
    int quantity
){
}
