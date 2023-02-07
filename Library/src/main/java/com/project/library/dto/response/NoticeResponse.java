package com.project.library.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NoticeResponse {

    private long id;                  // PK
    private String title;             // 제목
    private String content;           // 내용
    private LocalDateTime createdAt;   // 작성일
    private LocalDateTime modifiedAt; // 수정일
    private long memberId;            // FK
}
