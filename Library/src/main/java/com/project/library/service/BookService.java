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
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookMapper bookMapper;

    /**
     * 요청한 받은 정보를 DB에 저장
     * List로 요청 받은 category를 저장하기 위해 BookAndCategory 테이블에 필요한 객체 생성
     * @param requestDto
     * @return
     */
    public BookResponseDto saveBook(BookPostRequestDto requestDto) {
        bookMapper.saveBook(requestDto);
        //BookAndCategory 테이블에 저장하기 위한 객체 List 생성
        List<BookAndCategoryDto> bookAndCategoryDtoList = new ArrayList<>();
        for(int i = 0 ; i < requestDto.getCategoryList().size() ; i++){
            bookAndCategoryDtoList.add(new BookAndCategoryDto(requestDto.getId(),
                    requestDto.getCategoryList().get(i)));
        }
        bookMapper.saveBookCategory(bookAndCategoryDtoList);

        return findById(requestDto.getId());
    }

    public List<BookResponseDto> getBookByCategoryId(Long id) {
        return bookMapper.findByCategoryId(id);
    }

    public BookResponseDto deleteBook(Long bookId) {
        bookMapper.deleteBook(bookId);
        return bookMapper.findByBookId(bookId);
    }

    public void updateBook(BookPatchRequestDto patchRequest) {
        bookMapper.updateBook(patchRequest);
    }

    public BookResponseDto findById(Long bookId) {
        BookResponseDto responseDto = bookMapper.findByBookId(bookId);
        responseDto.setCategoryNames(String.join(" ,", bookMapper.findCategoryNamesByBookId(bookId)));

        return responseDto;
    }

    public List<BookResponseDto> findBook(String title, String writer) {

        List<BookResponseDto> bookResponseDtoList = bookMapper.findBook(title, writer);

//        for (BookResponseDto responseDto : bookResponseDtoList) {
//            List<String> categoryNameByBookId = bookMapper.findCategoryNamesByBookId(responseDto.getId());
//            responseDto.setCategoryNames(String.join(", ", categoryNameByBookId));
//        }

        for (int i = 0; i < bookResponseDtoList.size(); i++) {
            BookResponseDto responseDto = bookResponseDtoList.get(i);
            responseDto.setCategoryNames(String.join(" ,",
                    bookMapper.findCategoryNamesByBookId(responseDto.getId())));
        }

        return bookResponseDtoList;
    }

}
