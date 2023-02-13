package com.project.library.service;

import com.project.library.dto.request.ReviewRequestDto;
import com.project.library.dto.response.ReviewResponseDto;
import com.project.library.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewMapper reviewMapper;
    public void saveReview(ReviewRequestDto requestDto) {
        /**
         * DB에서 review에 BookId 와 MemberId가 동일하게 존재하는
         * 데이터가 있으면 작성할 수 없음
         */
        reviewMapper.saveReview(requestDto);
//        ReviewResponseDto response = reviewMapper.findReviewByBookId(requestDto.getBookId(), requestDto.getMemberId());
    }
//
//    public ReviewResponseDto findReviewByBookId(Long bookId, Long memberId) {
//        return reviewMapper.findReviewByBookId(bookId, memberId);
//    }
//
//    public List<ReviewResponseDto> findReviewListByBookId(Long bookId) {
//        return reviewMapper.findReviewListByBookId(bookId);
//    }
}
