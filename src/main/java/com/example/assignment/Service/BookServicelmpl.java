package com.example.assignment.Service;

import com.example.assignment.DTO.BookRequestDto;
import com.example.assignment.DTO.BookResponseDto;
import com.example.assignment.Domain.Book;
import com.example.assignment.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Currency;

@Service
@RequiredArgsConstructor
public class BookServicelmpl implements BookService{
    private final BookRepository bookRepository;
    @Transactional(readOnly = true)
    public Page<BookResponseDto> getList(Pageable pageable){
        return bookRepository.findAll(pageable).map(BookResponseDto::new);
    }

    @Override
    @Transactional
    public Long createBook(BookRequestDto requestDto,String local) {
        Currency money = null;
        String bookAuthor = requestDto.getAuthors().replaceAll("\\s", "");
        if (requestDto.getBookname() == null) throw new NullPointerException("책 이름을 입력해주세요");
        if (local.equals("KRW")){
            money = KRW;
        } else if (local.equals("USD")) {
            money = USD;
        } else if (local.equals("EUR")) {
            money = EUR;
        }else throw new RuntimeException("원, 달러, 유로의 값을 입력해주세요");
        if (!BookService.checkISBNNumber(requestDto.getIsbn())) throw new RuntimeException("ISBN 패턴에 맞는 값을 입력하시오");
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(requestDto.getPrice()));
        BigDecimal bigPrice = bigDecimal.divide(BigDecimal.valueOf(1)).subtract(BigDecimal.valueOf(bigDecimal.longValue()));
        String Pricelen = String.valueOf(bigPrice.doubleValue());
        if (Pricelen.length() - 2 > 2 )throw new RuntimeException("소수점 2자리 수까지의 값을 입력해주세요");
        return  bookRepository.save(Book.builder()
                .bookName(requestDto.getBookname())
                .extinction(requestDto.isExtinction())
                .isbn(requestDto.getIsbn())
                .bookpage(requestDto.getBookpage())
                .age(requestDto.getAge())
                .price(bigDecimal.doubleValue())
                .authors(bookAuthor)
                .currency(MessageFormat.format("{0}{1}", requestDto.getCurrency(), money.getSymbol()))
                .build()).getId();
    }
}