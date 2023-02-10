package com.project.library.service;

import com.project.library.dto.request.RentRequest;
import com.project.library.dto.response.RentResponse;
import com.project.library.mapper.RentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RentService {

    private final RentMapper rentMapper;

    /**
     * 대여 (정보 저장)
     * @param request
     * @return
     */
    public RentResponse saveRent(RentRequest request) {
        rentMapper.saveRent(request);
        rentMapper.updateBookStatus(request);
        return rentMapper.findById(request.getId());
    }

    /**
     * 대여정보 PK로 받아오기
     * @param id
     * @return
     */
    public RentResponse findById(Long id) {
        return rentMapper.findById(id);
    }
}
