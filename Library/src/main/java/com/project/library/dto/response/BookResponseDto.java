package com.project.library.dto.response;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.project.library.dto.request.BookPostRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Book 기능 응답에 대한 DTO
 */
@Getter
@Setter
public class BookResponseDto {
    private Long id;
    private String title; //책 제목
    private String writer; //책 지은이
    private Date publicateAt; //책 출판일
    private String status; //책 상태(대여 유/무, 입고 예정 등)
    private int recommend;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean deleteStatus;
    private List<Long> categoryId;
//    private Long

}
