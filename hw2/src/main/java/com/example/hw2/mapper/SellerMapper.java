package com.example.hw2.mapper;

import com.example.hw2.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

// Mybatis는 @Mapper가 붙은 인터페이스를 스캔 후에, 이를 DB와 매핑 및 스프링 컨테이너에 등록시켜준다.
@Mapper
public interface SellerMapper {
    List<Seller> selectAll();
    int selectAllCount();
    Optional<Seller> selectById(@Param("id") Long id);
    int insert(@Param("seller") Seller seller);
    int update(@Param("seller") Seller seller);
    int delete(@Param("seller") Seller seller);
}


