package com.ddingcode.sopoomshop.controller;

import com.ddingcode.sopoomshop.controller.form.MemberForm;
import com.ddingcode.sopoomshop.domain.Member;
import com.ddingcode.sopoomshop.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("form", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/create-member")
    public String create(MemberForm memberForm) {

        Member member = Member.createMember(memberForm.getName(),
                memberForm.getAddress(),
                memberForm.getPhone());
        memberService.save(member);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String list(Model model) throws JsonProcessingException {
        List<Member> members = memberService.findAll();
        String membersJsonType = objectMapper.writeValueAsString(members);
        model.addAttribute("members", membersJsonType);
        log.info("membersJsonType" + membersJsonType);
        return "members/memberList";
    }

}
