package com.loja.loja.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loja.loja.model.entity.Product;
import com.loja.loja.repository.ProductRepository;
import com.loja.loja.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

      public Product create(Product product) {        
        if(product.getId() != null) {
            throw new RuntimeException("Product already exist.");   
        }
        productRepository.save(product);
        
        return product;
    }

    public Optional<Product> findById(Long id) {
        return  productRepository.findById(id);
    }

   public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product update(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    
        product.setName(productDetails.getName());
    
        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        productRepository.save(product);        
    }

}
