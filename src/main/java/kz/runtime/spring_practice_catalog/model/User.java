package kz.runtime.spring_practice_catalog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String name;
    private String lastname;

    @Enumerated(value = EnumType.ORDINAL)
    private Role role;

    @Column(name = "registered_at")
    private LocalDateTime registeredDate;
}