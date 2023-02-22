package com.project.library.dto.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;       // 로그인 아이디
    private String password1;   // 로그인 비밀번호
}
