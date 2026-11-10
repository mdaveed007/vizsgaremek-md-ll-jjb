package com.primenready.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
