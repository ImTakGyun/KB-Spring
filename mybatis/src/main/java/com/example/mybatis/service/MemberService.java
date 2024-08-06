package com.example.mybatis.service;

import com.example.mybatis.Member;
import com.example.mybatis.mapper.ArticleMapper;
import com.example.mybatis.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final ArticleMapper articleMapper;

    public int unsubscribe(Long id) {
        Member member = memberMapper.selectById(id).orElseThrow();
        articleMapper.deleteById(member.getId());
        return memberMapper.delete(member);
    }

    @Transactional
    public void subscribeBatch(List<Member> members) {
        for (Member member : members) {
            memberMapper.insert(member);
        }
    }
}

