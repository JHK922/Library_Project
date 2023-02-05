package com.project.library.dto.request;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class BookPatchRequestDto {
    private Long id;
    private String title; //책 제목
    private String writer; //책 지은이
    private Date publicateAt; //책 출판일
    private String status; //책 상태(대여 유/무, 입고 예정 등)
    private LocalDateTime modifiedAt;
    private int recommend; //책 추천수
    private boolean deleteStatus; //책 삭제 상태(논리 삭제)
}
