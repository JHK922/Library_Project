package com.project.library.service;

import com.project.library.dto.request.NoticeRequest;
import com.project.library.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // 생성자 자동 생성
@Transactional
public class NoticeService {


    private final NoticeMapper noticeMapper;

    /**
     * 게시글 등록(저장)
     * @param request
     * @return Generated PK
     */
    public Long saveNotice(final NoticeRequest request) {
        noticeMapper.saveNotice(request);
        return request.getId();
    }
}

