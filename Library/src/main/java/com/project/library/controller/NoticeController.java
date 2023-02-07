package com.project.library.controller;

import com.project.library.dto.request.NoticeRequest;
import com.project.library.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping("")
    public Long saveNotice(@RequestBody NoticeRequest request) {
        return noticeService.saveNotice(request);
    }


}
