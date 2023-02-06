package com.project.library.controller;

import com.project.library.dto.request.CategoryPostRequestDto;
import com.project.library.dto.response.CategoryResponseDto;
import com.project.library.response.SingleResponse;
import com.project.library.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity saveCategory(@RequestBody CategoryPostRequestDto requestDto) {
        categoryService.saveCategory(requestDto);
        CategoryResponseDto responseDto = categoryService.findByName(requestDto.getName());
        return new ResponseEntity<>(new SingleResponse<>(responseDto), HttpStatus.CREATED);
    }

    @PatchMapping("{category-id}")
    public ResponseEntity updateCategory(@PathVariable("category-id")Long id, @RequestBody CategoryPostRequestDto requestDto) {
        requestDto.setId(id);
        categoryService.updateCategory(requestDto);

        CategoryResponseDto responseDto = categoryService.findById(id);

        return new ResponseEntity<>(new SingleResponse<>(responseDto), HttpStatus.OK);
    }
}
