package com.example.assignment.DTO;

import lombok.Getter;

@Getter
public class BookRequestDto {
    private String bookname;
    private Boolean extinction;
    private int isbn;
    private int bookpage;
    private int age;
    private double price;
    private int currency;
    private String author;
}
