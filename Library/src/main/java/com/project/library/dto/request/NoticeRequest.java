package com.project.library.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeRequest {

    private long id;                  // PK
    private String title;             // 제목
    private String content;           // 내용
    private LocalDateTime createdAt;   // 작성일
    private long memberId;            // FK

}
