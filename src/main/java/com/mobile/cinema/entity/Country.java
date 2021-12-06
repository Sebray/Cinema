package com.mobile.cinema.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "country", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;
}
