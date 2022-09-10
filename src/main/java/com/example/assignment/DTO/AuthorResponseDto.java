package com.example.assignment.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthorResponseDto {
    private Long id;
    private String name;
    private int birthday;
}