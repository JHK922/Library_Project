package com.project.library.service;

import com.project.library.dto.request.NoticeRequest;
import com.project.library.dto.response.NoticeResponse;
import com.project.library.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void saveNotice(NoticeRequest request) {
        noticeMapper.saveNotice(request);
    }

    /**
     * 게시글 전체 조회
     * @return 전체 회원정보
     */
    public List<NoticeResponse> findAll() {
        return noticeMapper.findAll();
    }

    /**
     * 게시글 지정 조회
     * @param id - PK
     * @return 지정 회원정보
     */
    public NoticeResponse findById(Long id) {
        return noticeMapper.findById(id);
    }

    /**
     * 게시글 지정 조회
     * @param memberId
     * @return 지정 회원정보
     */
    public NoticeResponse findByMemberId(Long memberId) {
        return noticeMapper.findByMemberId(memberId);
    }

    /**
     * 게시글 수정
     * @param request
     * @return PK
     */
    public void updateNotice(NoticeRequest request) {
        noticeMapper.updateNotice(request);
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public void deleteNotice(Long id) {
        noticeMapper.deleteById(id);
    }

}

