package com.example.hw2.mapper;

import com.example.hw2.domain.Product;
import com.example.hw2.domain.Seller;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:/test-product.sql"})
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void select() {
        log.info("전체조회 >>> " + productMapper.selectAll());
        log.info("단일조회 >>> " + productMapper.selectById(2L));
        log.info("총개수 >>> " + productMapper.selectAllCount());
        log.info("특정 셀러가 판대하는 상품목록 >>> " + productMapper.selectBySellerId(2L));
    }

    @Test
    public void insert() {
        Product product = Product.builder()
                .name("에어컨").price(2000000).sellerId(3L).build();
        log.info("추가상품 >>> " + product);
        log.info("추가 >>> " + productMapper.insert(product));
        log.info("전체상품조회 >>> " + productMapper.selectAll());
    }

    @Test
    public void update() {
        log.info("상품수정 >>> " + productMapper.update(1L, "자동차", 20000000));
        log.info("전체상품조회 >>> " + productMapper.selectAll());
    }

    @Test
    public void delete() {
        log.info("상품삭제 >>> " + productMapper.deleteById(1L));
        log.info("전체상품조회 >>> " + productMapper.selectAll());
    }
}
