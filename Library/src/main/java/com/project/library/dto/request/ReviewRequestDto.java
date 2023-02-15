package com.project.library.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewRequestDto {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean deleteStatus;
    private Long memberId;
    private Long bookId;
}
