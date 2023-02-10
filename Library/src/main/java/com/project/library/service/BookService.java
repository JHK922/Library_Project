package com.project.library.service;

import com.project.library.dto.request.BookPatchRequestDto;
import com.project.library.dto.request.BookPostRequestDto;
import com.project.library.dto.response.BookAndCategoryDto;
import com.project.library.dto.response.BookResponseDto;
import com.project.library.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookMapper bookMapper;

    /**
     * 요청한 받은 정보를 DB에 저장
     * 저장 후 정보 반환 -> 중복된 책이 존재하는 경우가 있기 때문에 가장 최근 등록한 정보로 가져온다
     * @param requestDto
     * @return
     */
    public Long saveBook(BookPostRequestDto requestDto) {
        bookMapper.saveBook(requestDto);

        BookAndCategoryDto bookAndCategoryDto = new BookAndCategoryDto();

        for(int i = 0 ; i < requestDto.getCategoryList().size() ; i++){
            bookAndCategoryDto.setBookId(requestDto.getId());
            bookAndCategoryDto.setCategoryId(requestDto.getCategoryList().get(i));
            bookMapper.saveBookCategory(bookAndCategoryDto);
        }
        return requestDto.getId();
    }
    /**
     * parameter로 책의 제목을 받음
     * @return 책 정보 반환
     */
    public BookResponseDto getInfoBook(String bookTitle) {
        return bookMapper.findByTitle(bookTitle);
    }

    public List<BookResponseDto> getBookByCategoryId(Long id) {
        return bookMapper.findByCategoryId(id);
//        return

    }

    public BookResponseDto deleteBook(Long bookId) {
        bookMapper.deleteBook(bookId);
        return bookMapper.findByBookId(bookId);
    }

    public void updateBook(BookPatchRequestDto patchRequest) {
        bookMapper.updateBook(patchRequest);
    }

    public BookResponseDto findById(Long bookId) {
        return bookMapper.findByBookId(bookId);
    }

    public List<BookResponseDto> findBook(String title, String writer) {
        return bookMapper.findBook(title, writer);
    }

}
