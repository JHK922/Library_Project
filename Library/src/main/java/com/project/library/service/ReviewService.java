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
    }

    /**
     * review 작성 글 수정
     * @param requestDto
     * @return
     */
    public Integer updateReview(ReviewRequestDto requestDto) {
        Integer integer = reviewMapper.updateReview(requestDto);
        return integer;
    }

    /**
     * book에 작성된 review list 조회
     * @param bookId
     * @return
     */
    public List<ReviewResponseDto> findReviewByBookId(Long bookId) {
        return reviewMapper.findReviewByBookId(bookId);
    }

    public List<ReviewResponseDto> findReviewsByMemberId(Long memberId) {
        return reviewMapper.findReviewsByMemberId(memberId);
    }

    public Integer deleteReview(Long reviewId) {
        return reviewMapper.deleteReview(reviewId);
    }

}
