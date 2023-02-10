package com.project.library.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RentRequest {

    private long id;                    // PK
    private LocalDateTime rentDate;     // 대여일
    private LocalDateTime returnDate;   // 반납일
    private int periodDate;             // 대여기간(14일)
    private long memberId;              // member PK
    private long bookId;                // book PK

}
