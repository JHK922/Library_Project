package com.project.library.dto.response;

import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Book 기능 응답에 대한 DTO
 */
@Getter
public class BookResponseDto {
    private Long id;
    private String title; //책 제목
    private String writer; //책 지은이
    private Date p_date; //책 출판일
    private String status; //책 상태(대여 유/무, 입고 예정 등)
    private int recommend;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean deleteStatus;

}
