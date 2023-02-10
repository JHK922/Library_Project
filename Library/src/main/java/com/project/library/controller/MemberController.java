package com.project.library.controller;

import com.project.library.dto.request.MemberRequest;
import com.project.library.dto.response.MemberResponse;
import com.project.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원정보 전체 조회
    @GetMapping("")
    public List<MemberResponse> findAll() {
        return memberService.findAll();
    }

    // 회원정보 지정 조회 (URI로 받음)
    @GetMapping("/{id}")
    public MemberResponse findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    // 회원정보 지정 조회 (파라미터로 받음)
    @GetMapping ("/find")
    public List<MemberResponse> findByName(@RequestParam String name) {
        return memberService.findByName(name);
    }

    // 회원정보 등록(저장)
    @PostMapping("")
    public MemberResponse saveMember(@RequestBody MemberRequest request) {
        memberService.saveMember(request);
        MemberResponse response = memberService.findById(request.getId());
        return response;
    }

    // 회원정보 수정
    @PutMapping("/{id}")
    public MemberResponse updateMember(@PathVariable Long id, @RequestBody MemberRequest request) {
        request.setId(id);
        memberService.updateMember(request);
        MemberResponse response = memberService.findById(id);
        return response;
    }

    // 회원정보 삭제(논리적 삭제)
    @DeleteMapping("/{id}")
    public MemberResponse deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        MemberResponse response = memberService.findById(id);
        return response;
    }
}
