package com.example.assignment.Service;

import com.example.assignment.DTO.BookRequestDto;
import com.example.assignment.DTO.BookResponseDto;
import org.springframework.data.domain.Page;

public interface BookService {
    public Long createBook(BookRequestDto requestDto);
    Page<BookResponseDto> getList(int page);
}
