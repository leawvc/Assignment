package com.example.assignment.Service;

import com.example.assignment.DTO.AuthorRequestDto;
import com.example.assignment.DTO.AuthorResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    public Long join(AuthorRequestDto requestDto);
    ResponseEntity<AuthorResponseDto> readMyAuthor(Long authorId);
}
