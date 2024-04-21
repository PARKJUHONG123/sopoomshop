package com.ddingcode.sopoomshop.mapper;

import com.ddingcode.sopoomshop.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    void save(Member member);
    Optional<Member> findById(Long id);
    List<Member> findAll();
}
