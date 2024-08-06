package com.example.mybatis;

import com.example.mybatis.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringMybatisApplication implements ApplicationRunner {

    private final MemberMapper memberMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(">>>" + memberMapper.selectAll());
        log.info(">>>" + memberMapper.selectById(2L));
        log.info(">>>" + memberMapper.selectAllOrderByAgeAsc());
        log.info(">>>" + memberMapper.selectAllCount());

        //INSERT
        Member member = Member.builder()
                .name("홍길동").email("gibong@hanbit.ac.kr").age(26)
                .build();

        log.info(">>>" + memberMapper.insert(member));
        log.info(">>>" + member);
    }
}
