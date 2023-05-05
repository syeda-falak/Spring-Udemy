package com.codingpractice.ProductService.Controller;

import com.codingpractice.ProductService.Model.ProductRequest;
import com.codingpractice.ProductService.Model.ProductResponse;
import com.codingpractice.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product" )
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
            long productId = productService.addProduct(productRequest);
            return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
            ProductResponse productResponse =productService.getProductById(productId);
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
