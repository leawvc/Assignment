package com.example.assignment.Controller;

import com.example.assignment.DTO.BookRequestDto;
import com.example.assignment.DTO.BookResponseDto;
import com.example.assignment.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/book/paging")
    public Page<BookResponseDto> getList(
            @RequestParam("page") int page
    ){
        return bookService.getList(page);
    }

    @PostMapping("/book")
    public Long createBook(@RequestBody BookRequestDto requestDto, @RequestParam String local){
        return bookService.createBook(requestDto,local);
    }
}
