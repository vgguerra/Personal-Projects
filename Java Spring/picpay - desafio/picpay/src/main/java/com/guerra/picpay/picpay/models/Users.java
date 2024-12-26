package com.guerra.picpay.picpay.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "document",unique = true)
    private String document;

    @Column(name = "email", unique = true)
    private String email;

    private String password;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
