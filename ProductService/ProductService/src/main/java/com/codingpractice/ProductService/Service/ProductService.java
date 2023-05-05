package com.codingpractice.ProductService.Service;

import com.codingpractice.ProductService.Model.ProductRequest;
import com.codingpractice.ProductService.Model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
