package com.mobile.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mobile.cinema.entity.Account;
import com.mobile.cinema.entity.Film;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class BuyingFilmsModel {
    @JsonProperty(value = "accountId")
    private Long accountId;

    @JsonProperty(value = "filmId")
    private Long filmId;

    @JsonProperty(value = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @JsonProperty(value = "isFavorite")
    private boolean isFavorite = false;

    @JsonProperty(value = "comment")
    private String comment = "";

    @JsonProperty(value = "score")
    private int score = 0;
}

