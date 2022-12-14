package com.example.assignment.Service;

import com.example.assignment.DTO.BookRequestDto;
import com.example.assignment.DTO.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Currency;

public interface BookService {
    Currency KRW = Currency.getInstance("KRW");
    Currency USD = Currency.getInstance("USD");
    Currency EUR = Currency.getInstance("EUR");
    public Long createBook(BookRequestDto requestDto, String local);
    Page<BookResponseDto> getList(Pageable pageable);
    static boolean checkISBNNumber(long number)
    {
        int sum = 0, j = 0;
        int i, t, intNumber, dNumber;
        String strNumber;
        strNumber = ""+number;
        if (strNumber.length() == 10){
            for (i = 0; i < strNumber.length(); i++) {
                intNumber = Integer.parseInt(strNumber.substring(i, i+1));
                dNumber = i + 1;
                t = dNumber * intNumber;
                sum = sum + t;
            }
            // check whether the sum is divisible by 11 or not
            if ((sum % 11) == 0) {
                return true;
            }
        }
        if (strNumber.length() == 13) {
            for (i = 0; i < strNumber.length(); i++) {
                intNumber = Integer.parseInt(strNumber.substring(i, i+1));
                if (i % 2 == 0){
                    j = j + intNumber;
                }else {
                    j = j + 3* intNumber;
                }
                sum = sum + j;
            }
            // check whether the sum is divisible by 11 or not
            if ((sum % 10) == 0) {
                return true;
            }
        }
        return false;
    }
}
