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

    // 회원정보 지정 조회
    @GetMapping("/{id}")
    public MemberResponse findById(@PathVariable long id) {
        return memberService.find(id);
    }

    // 회원정보 등록(저장)
    @PostMapping("")
    public Long saveMember(@RequestBody MemberRequest request) {
        return memberService.save(request);
    }

    // 회원정보 수정
    @PutMapping("")
    public void updateMember(@RequestBody MemberRequest request) {
        memberService.update(request);
    }

    // 회원정보 삭제(논리적 삭제)
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.delete(id);
//        log.info("member status -> {}", memberService.find(id).getDeleteYN());
    }
}
