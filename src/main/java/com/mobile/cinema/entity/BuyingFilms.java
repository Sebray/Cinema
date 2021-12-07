package com.mobile.cinema.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "list_of_films", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyingFilms implements Serializable {
    @EmbeddedId
    BuyingFilmsId id = new BuyingFilmsId();

    @JoinColumn(name = "film_id")
    @MapsId("film")
    @ManyToOne
    private Film film;

    @JoinColumn(name = "account_id")
    @MapsId("account")
    @ManyToOne
    private Account account;



    @NonNull
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public BuyingFilms(Film film, Account account, Date date) {
        this.film = film;
        this.account = account;
        this.date = date;
    }
}