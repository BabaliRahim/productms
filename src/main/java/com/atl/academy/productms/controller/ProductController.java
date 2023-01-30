package com.atl.academy.productms.controller;

import com.atl.academy.productms.dto.ProductDto;
import com.atl.academy.productms.dto.ProductRequest;
import com.atl.academy.productms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${product-url}")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }
    @PatchMapping("/{id}")
    public  void decreaseProductCount(@PathVariable Long id,@RequestParam Long count){
        productService.decreaseProductCount(id,count);
    }
}
