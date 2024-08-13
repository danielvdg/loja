package com.loja.loja.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loja.loja.model.dto.ProductDTO;

public interface ProductController {
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll();

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO);

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id);

}
