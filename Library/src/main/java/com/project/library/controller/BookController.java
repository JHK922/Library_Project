package com.project.library.controller;

import com.project.library.dto.request.BookPatchRequestDto;
import com.project.library.dto.request.BookPostRequestDto;
import com.project.library.dto.response.BookResponseDto;
import com.project.library.response.MultiResponse;
import com.project.library.response.SingleResponse;
import com.project.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Book CRUD 기능 우선 구현
 * ROLE_USER : R 기능 사용 가능
 * ROLE_MANAGER : CRUD 기능 사용 가능
 * ROLE_ADMIN : MANAGER와 동일
 * C : 제목, 지은이, 출판일, 출판사, 추천수
 * R : 출시일, 책 제목, 추천수 정렬, 페이징 기능
 * U : 부분 수정 가능하도록 구현
 * D : 삭제
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    /**
     * 책 정보 저장
     *
     * @param requestDto
     * @return 저장된 책에 대한 정보를 반환
     */
    @PostMapping
    public ResponseEntity insertBook(@RequestBody BookPostRequestDto requestDto) {
        bookService.saveBook(requestDto);
        BookResponseDto bookResponseDto = bookService.getInfoBook(requestDto.getTitle());
        log.info("Insert Book info -> {}", bookResponseDto);

        return new ResponseEntity<>(bookResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity getBookList() {
        log.info("Searching Book -> {}", bookService.getBookList());
        List<BookResponseDto> bookResponseDtoList = bookService.getBookList();

        return new ResponseEntity<>(new MultiResponse(bookResponseDtoList), HttpStatus.OK);
    }

    /**
     * 책 제목,  조회
     *
     * @param title, writer
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity getBookWithTitle(@RequestParam("title") String title,
                                           @RequestParam("writer") String writer) {
        if (!title.equals("null") && writer.equals("null")) {
            List<BookResponseDto> responseDto = bookService.getInfoBookWithTitle(title);

            log.info("title로 조회");
            return new ResponseEntity<>(new MultiResponse(responseDto), HttpStatus.OK);
        } else if (title.equals("null") && !writer.equals("null")) {
            List<BookResponseDto> responseDto = bookService.getInfoBookWithWriter(writer);

            log.info("writer 조회");
            return new ResponseEntity<>(new MultiResponse(responseDto), HttpStatus.OK);
        } else {
            log.info("둘 다 Null");
            List<BookResponseDto> bookResponseDtoList = bookService.getBookList();
            return new ResponseEntity<>(new MultiResponse<>(bookResponseDtoList), HttpStatus.OK);
        }
    }

    /**
     * book 논리적 삭제
     * @param bookId
     * @return bookResponseDto
     */
    @DeleteMapping("/{book-id}")
    public ResponseEntity deleteBook(@PathVariable("book-id") Long bookId) {
        BookResponseDto responseDto = bookService.deleteBook(bookId);
        log.info("Book DeleteStatus : N");
        return new ResponseEntity<>(new SingleResponse<>(responseDto), HttpStatus.OK);
    }

    /**
     * book 정보 업데이트
     * @param bookId
     * @retuen responseDto
     */
    @PutMapping("/{book-id}")
    public ResponseEntity updateBook(@PathVariable("book-id") Long bookId, @RequestBody BookPatchRequestDto patchRequest) {

        patchRequest.setId(bookId);
        bookService.updateBook(patchRequest);
        BookResponseDto responseDto = bookService.findById(bookId);

        return new ResponseEntity(new SingleResponse<>(responseDto), HttpStatus.OK);
    }
}
