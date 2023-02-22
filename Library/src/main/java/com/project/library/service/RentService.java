package com.project.library.service;

import com.project.library.dto.request.RentRequest;
import com.project.library.dto.response.RentResponse;
import com.project.library.mapper.BookMapper;
import com.project.library.mapper.RentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RentService {

    private final RentMapper rentMapper;
    private final BookMapper bookMapper;

    /**
     * 대여 (정보 저장)
     * book의 status 값을 확인하여 대여가능 상태 일때만 대여가 이루어짐
     * @param request
     */
    public void saveRent(RentRequest request) {
        String status = bookMapper.findByBookId(request.getBookId()).getStatus();
        if (status.equals("대여불가")) {
            System.out.println("현재 대여중입니다.");
        } else if (status.equals("대여가능")) {
            rentMapper.saveRent(request);
            rentMapper.updateBookStatusFalse(request); // 대여불가으로 update
            System.out.println("대여완료");
        }
    }

    /**
     * 반납 (정보 저장)
     * book의 status 값을 확인하여 대여불가 상태 일때만 반납이 이루어짐
     * @param id - PK
     * @return
     */
    public void updateReturn(Long id) {
        String status = rentMapper.findById(id).getStatus();
        if (status.equals("대여가능")) {
            System.out.println("현재 대여 가능한 상태입니다.");
        } else if (status.equals("대여불가")) {
            rentMapper.updateReturn(id);
            rentMapper.updateBookStatusTrue(id); // 대여가능으로 update
            System.out.println("반납완료");
        }
    }

    /**
     * 대여/반납정보 PK로 받아오기
     * @param id - PK
     * @return
     */
    public RentResponse findById(Long id) {
        return rentMapper.findById(id);
    }

    public String findStatus(RentRequest request) {
        String status = bookMapper.findByBookId(request.getBookId()).getStatus();
        return status;
    }
}
