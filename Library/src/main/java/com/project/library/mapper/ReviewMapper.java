package com.project.library.mapper;

import com.project.library.dto.request.ReviewRequestDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ReviewMapper {
    void saveReview(ReviewRequestDto requestDto);
    Integer updateReview(ReviewRequestDto requestDto);

}
