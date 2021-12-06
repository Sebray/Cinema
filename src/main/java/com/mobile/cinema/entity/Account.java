package com.mobile.cinema.entity;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "login")
    private String login;

    @NonNull
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "balance")
    private int balance = 0;

    @Column(name = "first_name")
    private String firstName = "user";

    @Column(name = "last_name")
    private String lastName = "user";

    @Column(name = "birthday")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @NonNull
    private Date birthday;

    @NonNull
    @JoinColumn(name = "country_id")
    @ManyToOne
    private Country country;

    public Account(String login, String password, String firstName, String lastName, Date birthday, Country country) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.country = country;
    }
}
