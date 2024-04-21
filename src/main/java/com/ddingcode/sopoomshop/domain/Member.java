package com.ddingcode.sopoomshop.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    private Long id;
    private String name;
    private String address;
    private String phone;

    public static Member createMember(String name, String address, String phone) {
        Member member = new Member();
        member.setName(name);
        member.setAddress(address);
        member.setPhone(phone);
        return member;
    }

}
