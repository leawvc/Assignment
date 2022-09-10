package com.example.assignment.Controller;

import com.example.assignment.DTO.AuthorRequestDto;
import com.example.assignment.DTO.AuthorResponseDto;
import com.example.assignment.Service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/author")
    public Long join(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.join(authorRequestDto);
    }
    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> readAuthorId(@PathVariable Long authorId){
        return authorService.readMyAuthor(authorId);
    }
}
