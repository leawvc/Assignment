package com.example.assignment.Service;

import com.example.assignment.DTO.AuthorRequestDto;
import com.example.assignment.DTO.AuthorResponseDto;
import com.example.assignment.Domain.Author;
import com.example.assignment.Repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorServicelmpl implements AuthorService{
    private final AuthorRepository authorRepository;

    @Override
    public Long join(AuthorRequestDto requestDto){
        return authorRepository.save(Author.builder()
                .birthday(requestDto.getBirthday())
                .name(requestDto.getName())
                .build()).getId();
    }
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<AuthorResponseDto> readMyAuthor(Long authorId){
        Author author = authorRepository.findById(authorId).orElseThrow(
                () ->  new IllegalArgumentException("해당하는 저자가 없습니다.")
        );
        return new ResponseEntity<>(
                new AuthorResponseDto(author.getId(),
                        author.getName(),
                        author.getBirthday()),
                HttpStatus.OK
        );
    }
}
