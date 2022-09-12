package com.example.assignment.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int birthday;
    @ManyToOne
    @JsonManagedReference
//    순환참조 방지
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    public void setBook(Book book){
        if (this.book != null){
            this.book.getAuthorList().remove(this);
        }
        this.book = book;
        book.addAuthor(this);
    }
}
