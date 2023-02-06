package com.project.library.service;

import com.project.library.dto.request.CategoryPostRequestDto;
import com.project.library.dto.response.CategoryResponseDto;
import com.project.library.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public void saveCategory(CategoryPostRequestDto requestDto) {
        categoryMapper.saveCategory(requestDto);
    }

    public CategoryResponseDto findByName(String name) {
        return categoryMapper.findByName(name);
    }
}
