package com.example.assignment.Controller;

import com.example.assignment.DTO.BookRequestDto;
import com.example.assignment.DTO.BookResponseDto;
import com.example.assignment.Service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @ApiOperation("페이징")
    @GetMapping("/book/paging")
    public Page<BookResponseDto> getList(@PageableDefault(sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        return bookService.getList(pageable);
    }
    @ApiOperation("책 생성")
    @PostMapping("/book")
    public Long createBook(@RequestBody BookRequestDto requestDto, @RequestParam String local){
        return bookService.createBook(requestDto,local);
    }
}
