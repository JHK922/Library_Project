package com.project.library.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 회원정보 생성, 수정에 사용 될 요청 클래스
 */

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRequest {

    private long id;            // PK
    private String email;       // 이메일 (로그인 아이디)
    private String password1;   // 비밀번호
    private String password2;   // 비밀번호 확인
    private String name;        // 이름
    private int birth;          // 생년월일
    private String address;     // 주소
    private String phone;       // 핸드폰번호
    private Date createAt;      // 가입날짜
}
