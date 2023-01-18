package com.example.assignment.member.model;

import com.example.assignment.Config.Timestamped;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String username;
    @Column(nullable = false,length = 100)
    private String password;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 20, nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false)
    private String role;
}
