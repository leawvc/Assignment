package com.example.assignment.Controller;

import com.example.assignment.DTO.AuthorRequestDto;
import com.example.assignment.DTO.AuthorResponseDto;
import com.example.assignment.Service.AuthorService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @ApiOperation("저자 생성")
    @PostMapping("/author")
    public Long join(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.join(authorRequestDto);
    }
    @ApiOperation("저자 id로 조회")
    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> readAuthorId(@PathVariable Long authorId){
        return authorService.readMyAuthor(authorId);
    }
}
