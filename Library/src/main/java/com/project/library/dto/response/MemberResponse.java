package com.project.library.dto.response;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * 회원정보 조회에 사용될 응답용 클래스
 */

@Data
public class MemberResponse {

    private long id;            // PK
    private String email;       // 이메일 (로그인 아이디)
    private String password1;   // 비밀번호
    private String name;        // 이름
    private int birth;          // 생년월일
    private String address;     // 주소
    private String phone;       // 핸드폰번호
    private Date createAt;      // 가입 날짜
    private boolean deleteYN;   // 삭제여부

}
