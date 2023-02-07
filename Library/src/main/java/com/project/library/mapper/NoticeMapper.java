package com.project.library.mapper;

import com.project.library.dto.request.NoticeRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

    /**
     * 게시글 저장
     * @param request
     */
    void saveNotice(NoticeRequest request);

}
