package com.example.productservice;

import com.example.productservice.dto.RequestProduct;
import com.example.productservice.dto.ResponseProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProducts(RequestProduct requestProduct) {
        Product product = new Product();
        product.setName(requestProduct.name());
        product.setPrice(requestProduct.price());
        product.setQuantity(requestProduct.quantity());
        product.setDescription(requestProduct.description());

        productRepository.save(product);

    }

    public List<ResponseProduct> getProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> ResponseProduct.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build())
                .toList();
    }

    public ResponseProduct getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return ResponseProduct.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, RequestProduct requestProduct) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")
        );
        if (requestProduct.name() != null){
            product.setName(requestProduct.name());
        }else
            product.setName(product.getDescription());
        if (requestProduct.price() != 0){
            product.setPrice(requestProduct.price());
        }else
            product.setPrice(product.getPrice());


        if (requestProduct.quantity() != 0){
            product.setQuantity(requestProduct.quantity());
        }else
            product.setQuantity(product.getQuantity());

        if (requestProduct.description() != null){
            product.setDescription(requestProduct.description());
        } else
            product.setDescription(product.getDescription());

        productRepository.save(product);
    }


}
