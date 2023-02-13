package com.project.library.controller;

import com.project.library.dto.request.BookPatchRequestDto;
import com.project.library.dto.request.BookPostRequestDto;
import com.project.library.dto.response.BookAndCategoryDto;
import com.project.library.dto.response.BookResponseDto;
import com.project.library.response.MultiResponse;
import com.project.library.response.SingleResponse;
import com.project.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
     * 책 정보 저장 후 최근 저장한 동일한 책의 데이터를 반환
     *
     * @param requestDto
     * @return 저장된 책에 대한 정보를 반환
     */
    @PostMapping
    public ResponseEntity createBook(@RequestBody BookPostRequestDto requestDto) {

        BookResponseDto responseDto = bookService.saveBook(requestDto);
        log.info("Created Book Id -> {}", requestDto.getId());
        log.info("Insert Category insert into Book -> {}", requestDto.getCategoryList());


        /**
         * book의 정보와 함께 categoryId List를 입력 받는다.
         * 테이블에 정보를 저장할 때 book의 ID와 categoryId List를 같이 저장해야한다.
         * 그럼 book request 클래스 필드에 List로 객체가 아닌 Long이 선언되어야 하는게 아닐까 ?
         */
        /**
         * book에 대한 정보를 입력 받는다. 기본 정보와 category id를 배열 형태로 입력 받는다.
         * book에 대한 정보를 book 테이블에 저장하고
         * 해당 book ID와 category id 배열을 bookAndCategory 테이블에 저장한다
         */
        return new ResponseEntity<>(new SingleResponse<>(responseDto), HttpStatus.CREATED);
    }

    /**
     * category ID를 이용한 book List 조회
     *
     * @param id
     * @return bookResponseDto
     */
    @GetMapping("/info/category/{category-id}")
    public ResponseEntity getBookListByCategoryId(@PathVariable("category") Long id) {
        log.info("Searching Book -> {}", bookService.getBookByCategoryId(id).size());
        List<BookResponseDto> responseDtoList = bookService.getBookByCategoryId(id);

        return new ResponseEntity<>(new MultiResponse(responseDtoList), HttpStatus.OK);
    }

    /**
     * 책 title 혹은 writer로 조회
     * @param title
     * @param writer
     * @return 책 정보를 모두 조회
     */

    @GetMapping("/info")
    public ResponseEntity getBooks(@RequestParam("title") String title,
                                   @RequestParam("writer") String writer) {
        List<BookResponseDto> responseDtos = bookService.findBook(title, writer);
        log.info("Get Books info");

        return new ResponseEntity<>(new MultiResponse<>(responseDtos), HttpStatus.OK);
    }

    /**
     * 책의 고유 id를 이용해 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public ResponseEntity getBook(@PathVariable("id") Long id) {
        BookResponseDto responseDto = bookService.findById(id);
        log.info("Get Book info -> {}", responseDto);
        return new ResponseEntity<>(new SingleResponse<>(responseDto), HttpStatus.OK);
    }

    /**
     * book 논리적 삭제
     *
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
     *
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
