package com.example.assignment.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "Book")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    Long id;
    @Column(nullable = false)
    private String bookName;
    @Column(nullable = false)
    private Boolean extinction;
    @Column(nullable = false)
    private int isbn;
    @Column(nullable = false)
    private int bookpage;
    @Column(nullable = false)
    private int age;
    @Column
    private double price;
    @Column
    private int currency;
    @Column
    private String author;
//    순환 참조 방지
    @JsonBackReference
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Author> authors = new ArrayList<>();
}
