package com.project.library.service;

import com.project.library.dto.request.CategoryPostRequestDto;
import com.project.library.dto.response.CategoryResponseDto;
import com.project.library.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public void saveCategory(CategoryPostRequestDto requestDto) {
        categoryMapper.saveCategory(requestDto);
    }
    public void updateCategory(CategoryPostRequestDto requestDto) {
        categoryMapper.updateCategory(requestDto);
    }
    public CategoryResponseDto findByName(String name) {
        return categoryMapper.findByName(name);
    }
    public CategoryResponseDto findById(Long id) {
        return categoryMapper.findById(id);
    }
    public List<CategoryResponseDto> findAll() {
        return categoryMapper.findAll();
    }
    public CategoryResponseDto deleteCategory(Long id) {
        return categoryMapper.deleteCategory(id);
    }
}
