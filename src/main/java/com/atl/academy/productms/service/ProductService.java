package com.atl.academy.productms.service;

import com.atl.academy.productms.dto.ProductDto;
import com.atl.academy.productms.dto.ProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
List<ProductDto> getAllProduct();
ProductDto getProductById(Long id);
void createProduct(ProductRequest productRequest);
void decreaseProductCount(Long id,Long count);
}
