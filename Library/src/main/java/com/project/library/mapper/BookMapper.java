package com.project.library.mapper;

import com.project.library.dto.request.BookPatchRequestDto;
import com.project.library.dto.request.BookPostRequestDto;
import com.project.library.dto.response.BookResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    /**
     * Book 전체 조회
     */
    List<BookResponseDto> getBookList();

    /**
     * Book 정보 저장(제목, 글쓴이, 출판일, 출판사를 파라미터로 사용)
     * @param requestDto
     */
    void saveBook(BookPostRequestDto requestDto);

    /**
     * 입력 또는 수정한 Book에 대한 정보를 Response
     * 하나의 책에 대한 정보를 가져옴
     * @param title
     * @return
     */
    BookResponseDto findByTitle(String title);

    /**
     * title에 대한 다수 정보 List로 조회
     * @param title
     * @return book list
     */
    List<BookResponseDto> findsByTitle(String title);


    /**
     * 책 글쓴이를 파라미터로 책을 조회
     * @param bookWriter
     * @return 동일한 글쓴이가 출판한 모든 책 조회
     */
    List<BookResponseDto> findByWriter(String bookWriter);

    //    List<BookResponseDto> findByCategoryId(Long categoryId);
    void deleteBook(Long bookId);

    BookResponseDto findByBookId(Long bookId);
    /**
     * 책 이름으로 조회, 내림차순 정렬(최신순)
     * @param patchRequest
     * @return
     */
//    List<BookResponseDto> getBookWithTitle(String bookTitle);

    void updateBook(BookPatchRequestDto patchRequest);

    List<BookResponseDto> findBook(String title, String writer);
}
