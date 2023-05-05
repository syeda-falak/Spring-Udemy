package com.codingpractice.ProductService.Service;

import com.codingpractice.ProductService.Entity.Product;
import com.codingpractice.ProductService.Exception.ProductServiceCustomException;
import com.codingpractice.ProductService.Model.ProductRequest;
import com.codingpractice.ProductService.Model.ProductResponse;
import com.codingpractice.ProductService.Repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding products...");

        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .productId(0).build();
        productRepository.save(product);
        log.info("Product Created...");


        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("get the product for product id"+ productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceCustomException("Product with Id not found", "404 Not Found"));

        ProductResponse productResponse= new ProductResponse();
        copyProperties(product,productResponse);
        return productResponse;
    }
}
