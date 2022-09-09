package com.example.assignment;

import com.example.assignment.Service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssignmentApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
//        for (int i = 1; i <= 300; i++) {
//            String subject = String.format("테스트 데이터입니다:[%03d]", i);
//            String content = "내용무";
//            this.bookService.create(subject, content);
//        }
    }

}
