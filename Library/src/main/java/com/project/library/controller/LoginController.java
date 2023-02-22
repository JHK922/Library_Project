package com.project.library.controller;

import com.project.library.dto.request.LoginRequest;
import com.project.library.dto.response.LoginResponse;
import com.project.library.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request, HttpSession session) {
        LoginResponse login = loginService.loginMember(request);

        if(login == null) {
            session.setAttribute("login", null);
            log.info("login session -> {}", session.getAttribute("login"));
            System.out.println("로그인 실패");
        } else {
            session.setAttribute("login", login);
            log.info("login session -> {}", session.getAttribute("login"));
            System.out.println("로그인 성공");
        }
        return login == null ? "false" : "true";
    }

    // 로그아웃
    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("login");
        log.info("login session -> {}", session.getAttribute("login"));
        System.out.println("로그아웃 성공");
    }
}
