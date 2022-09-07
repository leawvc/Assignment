package com.example.assignment.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    Long id;

    @Column(length = 255,nullable = false)
    private String bookName;

    @Column(nullable = false)
    private Boolean extinction;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Long page;

    @Column(nullable = false)
    private Long age;

    @Column
    private Long price;

    @Column
    private Long currency;

    @OneToMany(mappedBy = "book")
    private List<Author> authors = new ArrayList<Author>();
}
