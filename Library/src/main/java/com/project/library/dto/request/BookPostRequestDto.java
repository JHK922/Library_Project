package com.project.library.dto.request;

import com.project.library.dto.response.BookAndCategoryDto;
import lombok.Data;

import java.sql.Date;
import java.util.List;

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
    private List<Integer> categoryList; // 책에 카테고리 정보 입력
//    private Long categoryList; // 책에 카테고리 정보 입력
//    private List<Long> categoryIds;
}
