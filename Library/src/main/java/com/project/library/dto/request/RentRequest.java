package com.project.library.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RentRequest {

    private long id;                    // PK
    private LocalDateTime rentDate;     // 대여일
    private LocalDateTime returnDate;   // 반납일
    private Date expactedReturnDate;    // 반납예정일
    private long memberId;              // member PK
    private long bookId;                // book PK

}
