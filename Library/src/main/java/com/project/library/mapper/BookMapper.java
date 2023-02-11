package com.project.library.mapper;

import com.project.library.dto.request.BookPatchRequestDto;
import com.project.library.dto.request.BookPostRequestDto;
import com.project.library.dto.response.BookAndCategoryDto;
import com.project.library.dto.response.BookResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * Book 정보 저장(제목, 글쓴이, 출판일, 출판사를 파라미터로 사용)
     * @param requestDto
     */
    Long saveBook(BookPostRequestDto requestDto);

    void saveBookCategory(List<BookAndCategoryDto> bookAndCategoryDto);

    /**
     * 입력 또는 수정한 Book에 대한 정보를 Response
     * 하나의 책에 대한 정보를 가져옴
     * @param title
     * @return
     */
    BookResponseDto findByTitle(String title);

    List<BookResponseDto> findByCategoryId(Long id);
    void deleteBook(Long bookId);

    BookResponseDto findByBookId(Long bookId);

    List<Long> findCategoryByBook(Long id);
    /**
     * 책 이름으로 조회, 내림차순 정렬(최신순)
     * @param patchRequest
     * @return
     */

    void updateBook(BookPatchRequestDto patchRequest);

    List<BookResponseDto> findBook(String title, String writer);
}
