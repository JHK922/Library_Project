package com.project.library.controller;

import com.project.library.dto.request.NoticeRequest;
import com.project.library.dto.response.MemberResponse;
import com.project.library.dto.response.NoticeResponse;
import com.project.library.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    // 게시글 등록
    @PostMapping("")
    public Long saveNotice(@RequestBody NoticeRequest request) {
        return noticeService.saveNotice(request);
    }

    // 게시글 전체 조회
    @GetMapping("")
    public List<NoticeResponse> findAll() {
        return noticeService.findAll();
    }

    // 회원정보 지정 조회 (PK)
    @GetMapping("/{id}")
    public NoticeResponse findById(@PathVariable Long id) {
        return noticeService.findById(id);
    }

    // 회원정보 지정 조회 (name)
    @GetMapping ("/find")
    public NoticeResponse findByMemberId(@RequestParam Long memberId) {
        return noticeService.findByMemberId(memberId);
    }



}
