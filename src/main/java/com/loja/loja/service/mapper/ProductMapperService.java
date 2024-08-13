package com.loja.loja.service.mapper;

import com.loja.loja.model.dto.ProductDTO;
import com.loja.loja.model.entity.Product;

public interface ProductMapperService {

    public ProductDTO converterToDTO( Product product);

    public Product converterToEntity(ProductDTO productDTO);
    
}
