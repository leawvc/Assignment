package com.example.assignment.DTO;

import com.example.assignment.Domain.Author;
import lombok.Getter;

import java.util.List;

@Getter
public class BookRequestDto {
    private String bookname;
    private Boolean extinction;
    private int isbn;
    private int bookpage;
    private int age;
    private double price;
    private float currency;
    private String authors;
//    private List<Author> authorList;
}
