package com.loja.loja.data;

import com.loja.loja.model.entity.Product;

public class ProductDataMock {

    public static Product buildEntityDataMock(){
        return Product.builder()
                .id(1L)
                .name("jose valdo da silva")
                .build();
    }

    

}
