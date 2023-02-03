package com.project.library.service;

import com.project.library.dto.request.MemberRequest;
import com.project.library.dto.response.MemberResponse;
import com.project.library.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 자동 생성
public class MemberService {


    private final MemberMapper memberMapper;

    /**
     * 회원정보 등록(저장)
     * @param request
     * @return Generated PK
     */
    @Transactional
    public Long save(final MemberRequest request) {
        memberMapper.saveMember(request);
        return request.getId();
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
    public MemberResponse find(final Long id) {
        return memberMapper.findById(id);
    }

    /**
     * 회원정보 수정
     * @param request - 회원정보
     * @return PK
     */
    public Long update(MemberRequest request) {
        memberMapper.updateMember(request);
        return request.getId();
    }

    /**
     * 회원정보 삭제
     * @param id - PK
     * @return PK
     */
    public Long delete(final Long id) {
        memberMapper.deleteById(id);
        return id;
    }
}

