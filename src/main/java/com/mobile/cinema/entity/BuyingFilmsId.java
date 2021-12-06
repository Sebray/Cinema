package com.mobile.cinema.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class BuyingFilmsId implements Serializable {
    @Column(name = "film_id")
    private Long film;

    @Column(name = "account_id")
    private Long account;

    public BuyingFilmsId() {

    }

    public BuyingFilmsId(Long film, Long account){
        this.film =film;
        this.account=account;
    }

    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        BuyingFilmsId that = (BuyingFilmsId) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(film, that.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, film);
    }

}
