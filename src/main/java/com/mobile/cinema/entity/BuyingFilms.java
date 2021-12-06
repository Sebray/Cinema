package com.mobile.cinema.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "buying_films", schema = "public")
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

    @Column(name = "is_favorite")
    private boolean favorite = false;

    @Column(name = "comment")
    private String comment;

    @Column(name = "score")
    private int score = 0;

    public BuyingFilms(Film film, Account account, Date date, Boolean favorite, String comment, int score) {
        this.film = film;
        this.account = account;
        this.date = date;
        this.favorite = favorite;
        this.comment = comment;
        this.score = score;
    }
}