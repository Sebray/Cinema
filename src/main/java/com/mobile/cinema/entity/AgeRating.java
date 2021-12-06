package com.mobile.cinema.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "age_rating", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgeRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "limit")
    private String limit;
}
