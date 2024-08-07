package com.example.hw2.service;

import com.example.hw2.domain.Product;
import com.example.hw2.domain.Seller;
import com.example.hw2.mapper.ProductMapper;
import com.example.hw2.mapper.SellerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:/test-service.sql"})
public class SellerServiceTests {

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private SellerService sellerService;

    @Test
    public void registerProduct() {
        Seller seller = sellerMapper.selectById(1L).get();

        Product product1 = Product.builder().name("삼성 노트북").price(1500000).sellerId(seller.getId()).build();
        Product product2 = Product.builder().name("엘지 노트북").price(1000000).sellerId(seller.getId()).build();
        Product product3 = Product.builder().name("애플 노트북").price(2000000).sellerId(seller.getId()).build();

        List<Product> products = new ArrayList<>();
        products.add(product3);
        products.add(product2);
        products.add(product1);

        try {
            log.info("상품 추가 >>> " + product1);
            productMapper.insert(product1);

            log.info("상품 리스트 추가 >>> " + products);
            sellerService.registerProduct(products);
        } catch(Exception e){
            log.info("예외 발생 : Rollback");
            log.info("판매하는 상품 목록 >>> " + productMapper.selectBySellerId(1L));
        }
    }
}
