package com.project.library.dto.request;

import lombok.Data;

import java.sql.Date;

/**
 * BookEntity 설정
 */

@Data
public class BookPostRequestDto {

    private Long id;
    private String title; //책 제목
    private String writer; //책 지은이
    private Date publicateAt; //책 출판일
    private String status; //책 상태(대여 유/무, 입고 예정 등)

}
