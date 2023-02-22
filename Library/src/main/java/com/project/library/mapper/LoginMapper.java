package com.project.library.mapper;

import com.project.library.dto.request.LoginRequest;
import com.project.library.dto.response.LoginResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    /**
     * 로그인
     * @param request
     * @return
     */
    LoginResponse loginMember (LoginRequest request);


}

