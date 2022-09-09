package com.example.assignment.DTO;

import lombok.Getter;

@Getter
public class BookRequestDto {
    private String bookname;
    private Boolean extinction;
    private String isbn;
    private Long bookpage;
    private Long age;
    private Long price;
    private Long currency;
    private String author;
}
