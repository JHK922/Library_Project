package com.project.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class BookAndCategoryDto {
    private Long bookId;
    private Integer categoryId;

}
