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
        rentService.saveRent(request);
        RentResponse response = rentService.findById(request.getId());
        return response;
    }

    // 책 반납
    @PutMapping("/{id}")
    public RentResponse updateReturn(@PathVariable Long id) {
        rentService.updateReturn(id);
        RentResponse response = rentService.findById(id);
        return response;
    }
}
