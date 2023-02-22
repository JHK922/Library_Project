package com.project.library.dto.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String email;       // 로그인 아이디
    private String password1;   // 로그인 비밀번호
}
