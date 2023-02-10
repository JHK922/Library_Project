package com.project.library.controller;

import com.project.library.dto.request.RentRequest;
import com.project.library.dto.response.RentResponse;
import com.project.library.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


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

    // 책 반납
    @PutMapping("/{id}")
    public RentResponse updateReturn(@PathVariable Long id) {
        RentRequest request = new RentRequest();
        request.setId(id);
//        rentService.updateReturn(request);
        rentService.updateReturn(id);
        RentResponse response = rentService.findById(id);
        return response;
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
