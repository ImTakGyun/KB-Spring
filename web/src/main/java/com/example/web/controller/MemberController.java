package com.example.rest_api.controller;

import com.example.rest_api.dto.ArticleRequest;
import com.example.rest_api.dto.ArticleResponse;
import com.example.rest_api.dto.MemberRequest;
import com.example.rest_api.dto.MemberResponse;
import com.example.rest_api.model.Member;
import com.example.rest_api.repository.MemberRepository;
import com.example.rest_api.service.ArticleService;
import com.example.rest_api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final ArticleService articleService;

    @GetMapping
    public List<Member> get(@RequestParam(name="name", required = false) String name) {
        if (name != null) {
            return memberRepository.findByNameContaining(name);
        } else {
            return memberRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    public MemberResponse getById(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    @PostMapping
    public MemberResponse post(@RequestBody MemberRequest memberRequest) {
        return memberService.create(memberRequest);
    }

    @PutMapping("/{id}")
    public Member put(@PathVariable("id") Long id, @RequestBody Member member) {
        member.setId(id);
        return memberRepository.save(member);
    }

    @PatchMapping("/{id}")
    public Member patch(@PathVariable("id") Long id, @RequestBody Member patch) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null) {
            if (patch.getName() != null) member.setName(patch.getName());
            if (patch.getEmail() != null) member.setEmail(patch.getEmail());
            if (patch.getPassword() != null) member.setPassword(patch.getPassword());
            if (patch.getAge() != null) member.setAge(patch.getAge());
            if (patch.getEnabled() != null) member.setEnabled(patch.getEnabled());
            memberRepository.save(member);
        }
        return member;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        memberRepository.deleteById(id);
    }

    @PostMapping("/{id}/articles")
    public ArticleResponse postArticle(@PathVariable("id") Long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.create(id, articleRequest);
    }
}
