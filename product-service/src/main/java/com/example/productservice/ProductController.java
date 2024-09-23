package com.example.productservice;


import com.example.productservice.dto.RequestProduct;
import com.example.productservice.dto.ResponseProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void addProducts(@RequestBody RequestProduct requestProduct) {
        productService.addProducts(requestProduct);
    }

//    @PostMapping
//    public ResponseEntity<String> addProducts(@RequestBody RequestProduct requestProduct, @RequestHeader Map<String, String> headers) {
//        headers.forEach((key, value) -> System.out.println(key + ": " + value)); // Log headers
//
//        // Include the request headers in the response so Postman can display them
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setAll(headers);
//
//        productService.addProducts(requestProduct);
//
//        return new ResponseEntity<>("Product added", responseHeaders, HttpStatus.OK);
//    }


    @GetMapping
    public List<ResponseProduct> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ResponseProduct getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody RequestProduct requestProduct) {
        productService.updateProduct(id, requestProduct);
    }



}
