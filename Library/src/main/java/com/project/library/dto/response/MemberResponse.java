package com.project.library.dto.response;

import lombok.Data;

import java.util.Date;

/**
 * 회원정보 조회에 사용될 응답용 클래스
 */

@Data
public class MemberResponse {

    private long id;            // PK
    private String email;       // 이메일 (로그인 아이디)
    private String name;        // 이름
    private int birth;          // 생년월일
    private String address;     // 주소
    private String phone;       // 핸드폰번호
    private Date createdAt;      // 가입 날짜
    private boolean deleteYn;   // 삭제여부
    private long roleId;        // FK
    private String roleType;    // 권한(join)

}
