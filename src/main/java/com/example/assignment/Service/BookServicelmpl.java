package com.example.assignment.Service;

import com.example.assignment.DTO.BookRequestDto;
import com.example.assignment.DTO.BookResponseDto;
import com.example.assignment.Domain.Book;
import com.example.assignment.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;

@Service
@RequiredArgsConstructor
public class BookServicelmpl implements BookService{
    private final BookRepository bookRepository;
    @Transactional(readOnly = true)
    public Page<BookResponseDto> getList(int page){
        Pageable pageable = PageRequest.of(page,10);
        return bookRepository.findAll(pageable).map(BookResponseDto::new);
    }

    @Override
    @Transactional
    public Long createBook(BookRequestDto requestDto,String local) {
        Currency money = null;
//        String bookAuthor = Arrays.toString(requestDto.getAuthors().split(",| "));
        String bookAuthor = Arrays.toString(requestDto.getAuthors().split(",| "));
        if (local.equals("KRW")){
            money = KRW;
        } else if (local.equals("USD")) {
            money = USD;
        } else if (local.equals("EUR")) {
            money = EUR;
        }else throw new RuntimeException("원, 달러, 유로의 값을 입력해주세요");
        if (!BookService.checkISBNNumber(requestDto.getIsbn())) throw new RuntimeException("ISBN 패턴에 맞는 값을 입력하시오");
        String[] bookPrice= requestDto.getPrice().split("\\.");
        String bookMoney = null;
        if (requestDto.getPrice().contains(".")){
            if (bookPrice[1].length() > 2) throw new RuntimeException("소수점 2자리 수까지의 값을 입력해주세요");
            else {bookMoney = MessageFormat.format("{0}{1}{2}",bookPrice[0],".",bookPrice[1]);}
        }else {bookMoney = bookPrice[0];}
        return  bookRepository.save(Book.builder()
                .bookName(requestDto.getBookname())
                .extinction(requestDto.getExtinction())
                .isbn(requestDto.getIsbn())
                .bookpage(requestDto.getBookpage())
                .age(requestDto.getAge())
                .price(bookMoney)
                .authors(requestDto.getAuthors())
                .currency(MessageFormat.format("{0}{1}", requestDto.getCurrency(), money.getSymbol()))
                .build()).getId();
    }
}
