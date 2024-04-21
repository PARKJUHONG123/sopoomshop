package com.ddingcode.sopoomshop.repository;

import com.ddingcode.sopoomshop.domain.Member;
import com.ddingcode.sopoomshop.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberMapper memberMapper;

    public Member save(Member member) {
        memberMapper.save(member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return memberMapper.findById(id);
    }

    public List<Member> findAll() {
        return memberMapper.findAll();
    }

}
