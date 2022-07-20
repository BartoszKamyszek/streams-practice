package com.example.demo.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void shouldReturnProductByPriceWithList() {
        //given
        createAndSaveProduct("Book", new BigDecimal(10));
        createAndSaveProduct("Car", new BigDecimal(20));
        createAndSaveProduct("Car", new BigDecimal(10));
        createAndSaveProduct("Mouse", new BigDecimal(20));
        //when
        var actualOptional = productService.findProductByName("Car");
        //then
        var actual = actualOptional.get();
        assertThat(actual.getName()).isEqualTo("Car");
    }

    private Product createAndSaveProduct(String name, BigDecimal price) {
        return productRepository.save(Product.builder().name(name).price(price).build());
    }

}
