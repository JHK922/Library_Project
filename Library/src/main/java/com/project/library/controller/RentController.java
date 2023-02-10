package com.project.library.controller;

import com.project.library.dto.request.RentRequest;
import com.project.library.dto.response.RentResponse;
import com.project.library.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    // 책 대여
    @PostMapping("")
    public RentResponse saveRent(@RequestBody RentRequest request) {
        return rentService.saveRent(request);
    }
}

/**
 * RentRequest response = rentService.findById(request.getId());
 *
 *  RentResponse rentResponse = new RentResponse();
 *
 *  rentResponse.setId(response.getId());
 *  rentResponse.setRentDate(response.getRentDate());
 *  rentResponse.setReturnDate(response.getReturnDate());
 *  rentResponse.setPeriodDate(response.getPeriodDate());
 *  rentResponse.setMemberName(memberService.findById(request.getMemberId()).getName());
 *  rentResponse.setBookTitle(bookService.findById(request.getBookId()).getTitle());
 */
