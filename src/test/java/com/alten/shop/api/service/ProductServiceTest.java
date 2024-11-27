package com.alten.shop.api.service;

import com.alten.shop.api.model.Product;
import com.alten.shop.api.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private Product product;
    private List<Product> products;

    @BeforeEach
    public void startTest(){
        product = new Product(153, "code_152", "product_1", "Description_product_1", 10f, 10,"INSTOCK", "Stuff", "product1.jpg", 5);
        products = new ArrayList<Product>();
        products.add(product);
    }

    @Test
    public void getAllProductsTest() throws Exception{
        ProductService productService = new ProductServiceImpl(productRepository);
        when(productRepository.findAll()).thenReturn(products);
        List<Product> results = productService.getAllProducts();
        assertEquals(results.getFirst(), products.getFirst());
        verify(productRepository.findAll());
    }

}
