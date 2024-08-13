package com.loja.loja.service;

import java.util.List;
import java.util.Optional;

import com.loja.loja.model.entity.Product;

public interface ProductService {
    
    public Optional<Product> findById(Long id);     
    
    public List<Product> findAll();

    public Product create(Product productDTO);

    public Product update(Long id, Product product);

    public void delete(Long id);

}
