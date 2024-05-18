package com.ucc.crudservice.controller;

import com.ucc.crudservice.model.Product;
import com.ucc.crudservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return this.productService.getProducts();
    }


    //Metodo para crear ´producto

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void newProduct(@RequestBody Product product){
        this.productService.newProduct(product);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Long productId) {
        System.out.println(productId);
        this.productService.deleteProduct(productId);

    }


    @PatchMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        this.productService.updateProduct(productId, updatedProduct);
    }


}
