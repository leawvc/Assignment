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
    @Transactional
    public Long join(AuthorRequestDto requestDto){
        if (requestDto.getName() == null) throw new NullPointerException("이름을 입력해주세요");
        else if (requestDto.getName().length() > 100) throw new RuntimeException("100자안의 이름을 입력해주세요");
        int day = (int)(Math.log10(requestDto.getBirthday()) + 1);
        if (requestDto.getBirthday() == 0) throw new NullPointerException("생년 월일을 입력해주세요");
        else if (day != 8) throw new RuntimeException("생년월일을 ******** 8자리 양식에 맞게 입력해주세요");
        else{
            return authorRepository.save(Author.builder()
                    .birthday(requestDto.getBirthday())
                    .name(requestDto.getName())
                    .build()).getId();
        }
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
