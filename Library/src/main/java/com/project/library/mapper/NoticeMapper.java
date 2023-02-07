package com.project.library.mapper;

import com.project.library.dto.request.NoticeRequest;
import com.project.library.dto.response.NoticeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    /**
     * 게시글 저장
     * @param request
     */
    void saveNotice(NoticeRequest request);

    /**
     * 전체 게시글 조회
     * @return
     */
    List<NoticeResponse> findAll();

    /**
     * 해당 게시물 조회
     * @param id - Pk
     * @return
     */
    NoticeResponse findById(Long id);

    /**
     * 해당 게시물 조회
     * @param memberId - FK
     * @return
     */
    NoticeResponse findByMemberId(Long memberId);

    /**
     * 게시글 수정
     * @param request
     */
    void updateNotice(NoticeRequest request);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);



}
