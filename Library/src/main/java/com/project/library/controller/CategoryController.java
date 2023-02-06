package com.project.library.controller;

import com.project.library.dto.request.CategoryPostRequestDto;
import com.project.library.dto.response.CategoryResponseDto;
import com.project.library.response.SingleResponse;
import com.project.library.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity saveCategory(@RequestBody CategoryPostRequestDto requestDto) {
        categoryService.saveCategory(requestDto);
        CategoryResponseDto responseDto = categoryService.findByName(requestDto.getName());
        return new ResponseEntity<>(new SingleResponse<>(responseDto),HttpStatus.CREATED);
    }
}
