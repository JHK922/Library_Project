package com.project.library.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 회원정보 생성, 수정에 사용 될 요청 클래스

 * DTO(Data Transfer Object)
 * 계층 간 데이터 교환을 위해 사용하는 객체
 * 로직을 가지지 않는 순수한 데이터 객체 (Getter & Setter만 가진 클래스)
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
    private Date createdAt;     // 가입날짜
    private boolean deleteYn;   // 삭제 여부
    private long roleId;        // FK
    private String roleType;    // 권한(join)
}
