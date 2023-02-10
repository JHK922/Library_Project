package com.project.library.mapper;

import com.project.library.dto.request.RentRequest;
import com.project.library.dto.response.RentResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RentMapper {

    /**
     * 대여 (정보 저장)
     * @param request
     */
    void saveRent(RentRequest request);

    /**
     * 대여정보 PK로 가져오기
     * @param id
     */
    RentResponse findById(Long id);

    /**
     * 대여버튼을 누름과 동시에 book.status값 update
     * @param request
     */
    void updateBookStatus(RentRequest request);

}
