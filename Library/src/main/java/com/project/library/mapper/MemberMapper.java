package com.project.library.mapper;

import com.project.library.dto.request.MemberRequest;
import com.project.library.dto.response.MemberResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 유저 정보를 DB에 저장하기 위한 Mapper 인터페이스
 */

@Mapper
public interface MemberMapper {

    /**
     * 회원정보 등록(저장)
     * @param request - 요청 받은 회원 정보
     */
    void saveMember(MemberRequest request);

    /**
     * 전체 회원정보 조회
     */
    List<MemberResponse> findAll();

    /**
     * 해당 회원정보 조회
     * @param id - PK
     * @return 해당 회원 정보
     */
    MemberResponse findById(Long id);

    /**
     * 해당 회원정보 조회
     * @param name - PK
     * @return 해당 회원 정보
     */
    MemberResponse findByName(String name);

    /**
     * 회원정보 수정
     * @param request - 요청 받은 회원 정보
     */
    void updateMember(MemberRequest request);

    /**
     * 회원정보 삭제
     * @param id -PK
     */
    void deleteById(Long id);
}
