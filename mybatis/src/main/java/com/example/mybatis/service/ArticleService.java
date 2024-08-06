package com.example.mybatis.service;

import com.example.mybatis.Article;
import com.example.mybatis.Member;
import com.example.mybatis.dto.ArticleDto;
import com.example.mybatis.mapper.ArticleMapper;
import com.example.mybatis.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleMapper articleMapper;
    private final MemberMapper memberMapper;

    public ArticleDto getArticleById(Long id) {
        Article article = (Article) articleMapper.selectByMemberId(id);
        return mapToArticleDto(article);
    }

    public List<ArticleDto> getArticleAll() {
        return articleMapper.selectAll().stream().map(this::mapToArticleDto).toList();
    }

    private ArticleDto mapToArticleDto(Article article) {
        Member member = memberMapper.selectById(article.getMemberId()).orElseThrow();
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .name(member.getName())
                .email(member.getEmail())
                .updated(article.getUpdated()).build();
    }
}

