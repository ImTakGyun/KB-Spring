package com.example.hw2.mapper;

import com.example.hw2.domain.Seller;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Slf4j
@Sql(scripts = {"classpath:/test-seller.sql"})
public class SellerMapperTests {

    @Autowired
    private SellerMapper sellerMapper;

    @Test
    public void select() {
        log.info("전체셀러조회 >>> " + sellerMapper.selectAll());
        log.info("단일셀러조회 >>> " + sellerMapper.selectById(2L));
        log.info("상품개수 >>> " + sellerMapper.selectAllCount());
    }

    @Test
    public void insert() {
        Seller seller = Seller.builder()
                .name("홍길동").age(28).build();
        log.info("추가될 셀러 >>> " + seller);
        log.info("추가 >>> " + sellerMapper.insert(seller));
        log.info("전체셀러조회 >>> " + sellerMapper.selectAll());
    }

    @Test
    public void update() {
        Seller seller = Seller.builder()
                .id(1L).name("임탁균").age(27).build();
        log.info("업데이트될 셀러 >>> " + seller);
        log.info("업데이트 >>> " + sellerMapper.update(seller));
        log.info("전체셀러조회 >>> " + sellerMapper.selectAll());
    }

    @Test
    public void delete() {
        Seller seller = Seller.builder()
                .id(1L).name("윤서준").age(20).build();
        log.info("삭제될 셀러 >>> " + seller);
        log.info("삭제 >>> " + sellerMapper.delete(seller));
        log.info("전체셀러조회 >>> " + sellerMapper.selectAll());
    }
}
