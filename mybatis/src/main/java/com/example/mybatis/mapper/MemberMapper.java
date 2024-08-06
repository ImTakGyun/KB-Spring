package com.example.mybatis.mapper;

import com.example.mybatis.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

// Mybatis는 @Mapper가 붙은 인터페이스를 스캔 후에, 이를 DB와 매핑 및 스프링 컨테이너에 등록시켜준다.
@Mapper
public interface MemberMapper {


    List<Member> selectAll();
    List<Member> selectAllOrderByAgeAsc();
    int selectAllCount();
    Optional<Member> selectById(@Param("id") Long id);

    // INSERT
    int insert(@Param("member") Member member);
}
