package com.loja.loja.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.loja.loja.data.ProductDataMock;
import com.loja.loja.model.entity.Product;
import com.loja.loja.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    public ProductServiceImpl productServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }       
    
    @Test
    public void shouldCreateProductSuccess() {
        var productMock = ProductDataMock.buildEntityDataMock();

        when(productRepository.save(productMock)).thenReturn(productMock);

        Product product = productRepository.save(productMock);

        assertNotNull(product);
        assertEquals(product, productMock);
    
    }

    @Test
    public void shouldCreateProductWithIdThrowsException() {
        Product product = ProductDataMock.buildEntityDataMock();
      
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productServiceImpl.create(product);
        });

        assertEquals("Product already exist.", exception.getMessage());
    }

    // @Test
    // public void shouldFindByIdSuccess() {
    //     var product = ProductDataMock.buildEntityDataMock();

    //     when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        
    //     Optional<Product> foundProduct = productServiceImpl.findById(product.getId());

    //     assertNotNull(foundProduct);
    //     assertEquals(product.getName(), foundProduct.get().getName());
    // }

}
