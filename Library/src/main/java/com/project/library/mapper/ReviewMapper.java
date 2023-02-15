package com.project.library.mapper;

import com.project.library.dto.request.ReviewRequestDto;
import com.project.library.dto.response.ReviewResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReviewMapper {
    void saveReview(ReviewRequestDto requestDto);
    Integer updateReview(ReviewRequestDto requestDto);
    List<ReviewResponseDto> findReviewByBookId(Long bookId);
    List<ReviewResponseDto> findReviewsByMemberId(Long memberId);
}
