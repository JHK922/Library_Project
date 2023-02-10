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
        rentMapper.updateBookStatusFalse(request); // 대여불가으로 update
        return rentMapper.findById(request.getId());
    }

    /**
     * 반납 (정보 저장)
     * @param id - PK
     * @return
     */
    public RentResponse updateReturn(Long id) {
        rentMapper.updateReturn(id);
        rentMapper.updateBookStatusTrue(id); // 대여가능으로 update
        return rentMapper.findById(id);
    }

    /**
     * 대여/반납정보 PK로 받아오기
     * @param id - PK
     * @return
     */
    public RentResponse findById(Long id) {
        return rentMapper.findById(id);
    }
}
