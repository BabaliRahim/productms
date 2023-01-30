package com.atl.academy.productms.service;

import com.atl.academy.productms.dto.ProductDto;
import com.atl.academy.productms.dto.ProductRequest;
import com.atl.academy.productms.entity.Product;
import com.atl.academy.productms.mapper.ProductMapper;
import com.atl.academy.productms.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProduct() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.findById(id).map(ProductMapper::mapEntityToDto).get();
    }

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = ProductMapper.mapRequestToEntity(productRequest);
        productRepository.save(product);
    }

    @Override
    public void decreaseProductCount(Long id, Long count) {
        var product = productRepository.findById(id).get();
        product.setCount(product.getCount() - count);
        productRepository.save(product);
    }
}
