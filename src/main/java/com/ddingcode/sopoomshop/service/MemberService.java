package com.ddingcode.sopoomshop.service;

import com.ddingcode.sopoomshop.domain.Member;
import com.ddingcode.sopoomshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member save(Member member) {
        memberRepository.save(member);

        return memberRepository.findById(member.getId())
                .orElseThrow(() -> new IllegalArgumentException("save error"));
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }


}
