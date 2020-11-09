package com.turner.Ecommerce.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACCOUNTS")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    public enum AccountType {
        ADMIN,
        PATRON
    }

    @NonNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NotNull
    private LocalDate accountOpened;

}
