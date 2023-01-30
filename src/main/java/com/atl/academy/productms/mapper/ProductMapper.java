package com.atl.academy.productms.mapper;

import com.atl.academy.productms.dto.ProductDto;
import com.atl.academy.productms.dto.ProductRequest;
import com.atl.academy.productms.entity.Product;

public class ProductMapper {
    public static Product mapDtoToEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .count(productDto.getCount())
                .price(productDto.getPrice())
                .build();
    }

    public static ProductDto mapEntityToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .count(product.getCount())
                .price(product.getPrice())
                .build();
    }

    public static Product mapRequestToEntity(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .count(productRequest.getCount())
                .price(productRequest.getPrice())
                .build();
    }
}
