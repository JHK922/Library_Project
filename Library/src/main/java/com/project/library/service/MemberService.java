package com.project.library.service;

import com.project.library.dto.request.MemberRequest;
import com.project.library.dto.response.MemberResponse;
import com.project.library.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor // 생성자 자동 생성
@Transactional
public class MemberService {


    private final MemberMapper memberMapper;

    /**
     * 회원정보 등록(저장)
     * Email 중복검사, 비밀번호 일치 여부 확인
     * @param request
     */
    public void saveMember(MemberRequest request) {
        int emailResult = memberMapper.checkEmail(request.getEmail()); // email 중복검사
        if (emailResult == 1) {
            log.info("email1 -> {}", emailResult);
            System.out.println("기존 사용자가 있습니다");
        } else if (emailResult == 0) {
            log.info("email2 -> {}", emailResult);
            if(request.getPassword1().equals(request.getPassword2())) {
                System.out.println("비밀번호가 일치 합니다.");
                memberMapper.saveMember(request); // 중복된 값이 없다면 저장
                System.out.println("이메일을 사용할 수 있습니다.");
                System.out.println("가입완료");
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }

    }

    /**
     * 회원정보 전체 조회
     * @return 전체 회원정보
     */
    public List<MemberResponse> findAll() {
        return memberMapper.findAll();
    }

    /**
     * 회원정보 지정 조회
     * @param id - PK
     * @return 지정 회원정보
     */
    public MemberResponse findById(Long id) {
        return memberMapper.findById(id);
    }

    /**
     * 회원정보 지정 조회
     * @param name
     * @return 지정 회원정보
     */
    public List<MemberResponse> findByName(String name) {
        return memberMapper.findByName(name);
    }

    /**
     * 회원정보 수정
     * @param request - 회원정보
     */
    public void updateMember(MemberRequest request) {
        memberMapper.updateMember(request);
    }

    /**
     * 회원정보 삭제
     * @param id - PK
     */
    public void deleteMember(final Long id) {
        memberMapper.deleteById(id);
    }

}

