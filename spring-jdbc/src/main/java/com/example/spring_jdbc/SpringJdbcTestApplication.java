package com.example.spring_jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

// Spring을 시작하게 되면, Spring이 ApplicationRunner를 구현한 객체들을 찾아서 실행시킴
@Component
@Slf4j
public class SpringJdbcTestApplication implements ApplicationRunner {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 1. 조회
//        List<Member> members = memberMapper.findAll();
//        log.info(members.toString());
//        log.info(">>>" + members);

        // 2. 삽입
//        memberMapper.insert(Member.builder()
//                .name("홍길동")
//                .email("GildongHong@hanbit.ac.kr")
//                .age(16)
//                .build());

        // 3. 수정
//        log.info("update returns " + memberMapper.update(Member.builder()
//                .id(5L)
//                .name("홍길동2")
//                .email("GildongHong2@hanbit.co.kr")
//                .age(17).build()));

        log.info("delete returns " + memberMapper.delete(5L));

    }
}
