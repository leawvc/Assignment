package com.example.assignment.Service;

import com.example.assignment.DTO.BookRequestDto;
import com.example.assignment.DTO.BookResponseDto;
import com.example.assignment.Domain.Book;
import com.example.assignment.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class BookServicelmpl implements BookService{
    private final BookRepository bookRepository;
//    private final Currency currency;
    @Transactional(readOnly = true)
    public Page<BookResponseDto> getList(int page){
        Pageable pageable = PageRequest.of(page,10);
        return bookRepository.findAll(pageable).map(BookResponseDto::new);
    }

    @Override
    @Transactional
    public Long createBook(BookRequestDto requestDto) {
        String bookAuthor = Arrays.toString(requestDto.getAuthors().split(",| "));
//        if (!BookService.checkISBNNumber(requestDto.getIsbn())) throw new RuntimeException("ISBN 패턴에 맞는 값을 입력하시오");
//        Locale usa = new Locale("en","us");
//        Currency dollars = currency.getInstance(usa);
//        NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
        return  bookRepository.save(Book.builder()
                .bookName(requestDto.getBookname())
                .extinction(requestDto.getExtinction())
                .isbn(requestDto.getIsbn())
                .bookpage(requestDto.getBookpage())
                .age(requestDto.getAge())
                .price(requestDto.getPrice())
//                .currency(Integer.parseInt(dollarFormat.format(requestDto.getCurrency())))
                .currency(requestDto.getCurrency())
                .author(bookAuthor)
                .build()).getId();
    }
}
