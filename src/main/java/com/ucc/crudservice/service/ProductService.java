package com.ucc.crudservice.service;

import com.ucc.crudservice.model.Product;
import com.ucc.crudservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void newProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Long id, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            // Actualiza solo los campos proporcionados en el objeto updatedProduct
            if (updatedProduct.getSku() != null) {
                existingProduct.setSku(updatedProduct.getSku());
            }
            if (updatedProduct.getName() != null) {
                existingProduct.setName(updatedProduct.getName());
            }
            if (updatedProduct.getDescription() != null) {
                existingProduct.setDescription(updatedProduct.getDescription());
            }
            if (updatedProduct.getPrice() != null) {
                existingProduct.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getStatus() != null) {
                existingProduct.setStatus(updatedProduct.getStatus());
            }

            productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("No se encontró el producto con ID: " + id);
        }
    }
}


