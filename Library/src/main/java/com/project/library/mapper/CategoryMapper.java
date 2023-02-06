package com.project.library.mapper;

import com.project.library.dto.request.CategoryPostRequestDto;
import com.project.library.dto.response.CategoryResponseDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    void saveCategory(CategoryPostRequestDto postRequestDto);

    CategoryResponseDto findByName(String name);

}
