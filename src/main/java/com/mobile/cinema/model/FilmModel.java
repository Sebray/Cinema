package com.mobile.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class FilmModel {
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "price")
    private int price = 0;

    @JsonProperty(value = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @JsonProperty(value = "rating")
    private int rating = 0;

    @JsonProperty(value = "ageRatingId")
    private Long ageRatingId;

    @JsonProperty(value = "genreId")
    private Long genreId;

    @JsonProperty(value = "countryId")
    private Long countryId;
}
