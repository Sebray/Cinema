package com.mobile.cinema.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "film", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "price")
    private int price = 0;

    @NonNull
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "rating")
    private int rating = 0;

    @NonNull
    @JoinColumn(name = "age_rating_id")
    @ManyToOne
    private AgeRating ageRating;

    @NonNull
    @JoinColumn(name = "genre_id")
    @ManyToOne
    private Genre genre;

    @NonNull
    @JoinColumn(name = "country_id")
    @ManyToOne
    private Country country;

    public Film(String name, int price, Date date, int rating, AgeRating ageRating, Genre genre, Country country) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.rating = rating;
        this.ageRating = ageRating;
        this.genre = genre;
        this.country = country;
    }
}

