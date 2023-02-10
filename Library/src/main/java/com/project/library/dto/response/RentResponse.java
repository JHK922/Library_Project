package com.project.library.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RentResponse {

    private long id;                    // PK
    private LocalDateTime rentDate;     // 대여일
    private LocalDateTime returnDate;   // 반납일
    private int periodDate;             // 대여기간(14일)
    private String memberId;            // member PK
    private String title;               // 책 이름 (book.title)
    private String status;              // 책 대여 상태 (book.status)
}
