package com.project.library.service;

import com.project.library.dto.request.LoginRequest;

import com.project.library.dto.response.LoginResponse;
import com.project.library.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    /**
     * 로그인
     * @param request
     * @return
     */
    public LoginResponse loginMember (LoginRequest request) {
        return loginMapper.loginMember(request);
    }

}
