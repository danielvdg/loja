package com.loja.loja.service.mapper.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.loja.loja.model.dto.ProductDTO;
import com.loja.loja.model.entity.Product;
import com.loja.loja.service.mapper.ProductMapperService;

@Service
public class ProductMapperServiceImpl implements ProductMapperService {
    
    private ModelMapper modelMapper = new ModelMapper();

    public ProductDTO converterToDTO( Product product) {
        
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product converterToEntity(ProductDTO productDTO) {
        
        return modelMapper.map(productDTO, Product.class);
    }
}