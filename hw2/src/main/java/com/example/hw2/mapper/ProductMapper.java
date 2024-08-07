package com.example.hw2.mapper;

import com.example.hw2.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Results(id="productResult", value={
            @Result(property="name", column="name"),
            @Result(property="price", column="price"),
            @Result(property="sellerId", column="seller_id")
    })
    @Select("SELECT * FROM product")
    List<Product> selectAll();

    @Select("SELECT COUNT(*) FROM product")
    int selectAllCount();

    @ResultMap("productResult")
    @Select("SELECT * FROM product WHERE id=#{id}")
    Product selectById(@Param("id") Long id);


    @ResultMap("productResult")
    @Select("SELECT * FROM product WHERE seller_id=#{sellerId}")
    List<Product> selectBySellerId(@Param("sellerId") Long sellerId);

    @Insert("""
        INSERT INTO product(name, price, created, updated, seller_id)
            VALUES(#{product.name}, #{product.price}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, #{product.sellerId})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("product") Product product);

    @Update("""
        UPDATE product
            SET name=#{name}, price=#{price}, updated=CURRENT_TIMESTAMP
            WHERE id=#{id}
    """)
    int update(@Param("id") Long id, @Param("name") String name, @Param("price") Integer price);

    @Delete("DELETE product WHERE id=#{id}")
    int deleteById(@Param("id") Long id);
}

