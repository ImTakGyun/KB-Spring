package com.example.spring_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberMapper {

    @Autowired
    private MemberRowMapper memberRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 보통은 한 개 이상의 결과값 도출을 위해서는 query() 를 사용
    // 만약 아무것도 조회되지 않아도 null 로서 동작하기 때문 (queryForObject 는 아무것도 조회되지 않으면 예외를 반환해버림)
    public List<Member> findAll(){
        return jdbcTemplate.query("SELECT * FROM member", memberRowMapper);
    }

    public Member findById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM member WHERE id = ?", memberRowMapper, 5);
//        List<Member> members = jdbcTemplate.query("SELECT * FROM member WHERE id = ?", memberRowMapper);
//        return members.stream().findFirst();
    }

    // 개수를 얻어올 때, queryForObject 사용
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM member", Integer.class);
    }

    public int insert(Member member){
        return jdbcTemplate.update("INSERT member(name, email, age) VALUES(?, ?, ?)",
                member.getName(), member.getEmail(), member.getAge());
    }

    public int update(Member member) {
        return jdbcTemplate.update("UPDATE member SET name=?, email=?, age=? WHERE id=?",
                member.getName(), member.getEmail(), member.getAge(), member.getId());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM member WHERE id=?", id);
    }

}
