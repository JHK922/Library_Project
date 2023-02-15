package com.project.library.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewList {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
}
