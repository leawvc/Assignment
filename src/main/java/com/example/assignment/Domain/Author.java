package com.example.assignment.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    Long id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(nullable = false)
    private Long birthday;
    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;
}
