package com.project.library.controller;

import com.project.library.dto.request.NoticeRequest;
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
    public NoticeResponse saveNotice(@RequestBody NoticeRequest request) {
        noticeService.saveNotice(request);
        NoticeResponse response = noticeService.findById(request.getId());
        return response;
    }

    // 게시글 전체 조회
    @GetMapping("")
    public List<NoticeResponse> findAll() {
        return noticeService.findAll();
    }

    // 게시글 지정 조회 (PK)
    @GetMapping("/{id}")
    public NoticeResponse findById(@PathVariable Long id) {
        return noticeService.findById(id);
    }

    // 게시글 지정 조회 (meberId)
    @GetMapping ("/find")
    public NoticeResponse findByMemberId(@RequestParam Long memberId) {
        return noticeService.findByMemberId(memberId);
    }

    // 게시글 업데이트
    @PutMapping("/{id}")
    public NoticeResponse updateNotice(@PathVariable Long id, @RequestBody NoticeRequest request) {
        request.setId(id);
        noticeService.updateNotice(request);
        NoticeResponse response = noticeService.findById(id);
        return response;
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public NoticeResponse deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        NoticeResponse response = noticeService.findById(id);
        return response;
    }



}
