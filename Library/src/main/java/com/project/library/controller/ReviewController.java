package com.project.library.controller;

import com.project.library.dto.request.ReviewRequestDto;
import com.project.library.dto.response.ReviewResponseDto;
import com.project.library.response.SingleResponse;
import com.project.library.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * book에 대한 review
 * C : bookId, memberId를 기반으로 review를 작성
 * R : BookId에 대한 review를 List로 조회
 *   : BookId와 memberId로 단일건 조회
 * U : review에 대한 수정
 * D : bookId와 reviewId에 대한 삭제 기능
 */
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @PostMapping("")
    public ResponseEntity createReview(@RequestBody ReviewRequestDto requestDto) {
        reviewService.saveReview(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{review-id}")
    public ResponseEntity updateReview(@PathVariable("review-id")Long id, @RequestBody ReviewRequestDto requestDto) {
        requestDto.setId(id);
        return new ResponseEntity<>(new SingleResponse<>(reviewService.updateReview(requestDto)),HttpStatus.OK);
    }
}

