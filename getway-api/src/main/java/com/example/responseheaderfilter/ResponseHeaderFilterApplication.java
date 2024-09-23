package com.example.responseheaderfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ResponseHeaderFilterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResponseHeaderFilterApplication.class, args);
    }
    @Bean
    public RouteLocator getWayRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("productservice", r -> r.path("/api/v1/products/**")
                        .filters(
                                f -> f
                                        .addRequestHeader("X-Request-Header", "Product-Service Header")
                                        .addResponseHeader("X-Response-Header", "Product-Service Header")
                        )
                        .uri("lb://product-service"))
                .build();
    }
}
