package com.turner.Ecommerce.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private String email;

    @NonNull
    private String title;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @NonNull
    private long mobileNumber;

    @NonNull
    private String password;

    @NotNull
    private LocalDate accountOpened;

}
