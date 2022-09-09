package com.example.assignment.DTO;

import com.example.assignment.Domain.Book;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookResponseDto {
    private Long bookId;
    private String bookname;
    private Boolean extinction;
    private String isbn;
    private Long bookpage;
    private Long age;
    private Long price;
    private Long currency;
    private String author;

    public BookResponseDto(Book book){
        this.bookId = book.getId();
        this.bookname = book.getBookName();
        this.extinction = book.getExtinction();
        this.isbn = book.getIsbn();
        this.bookpage = book.getBookpage();
        this.age = book.getAge();
        this.price = book.getPrice();
        this.currency = book.getCurrency();
        this.author = book.getAuthor();
    }
}
