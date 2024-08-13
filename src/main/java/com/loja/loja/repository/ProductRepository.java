package com.loja.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.loja.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
        
}