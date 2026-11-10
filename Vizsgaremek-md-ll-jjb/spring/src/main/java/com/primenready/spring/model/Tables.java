package com.primenready.spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "restaurant_id", nullable = false)
    private Integer restaurantId;

    @Column(name = "table_number", nullable = false)
    private String tableNumber;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "is_active", nullable = false, columnDefinition = "TINYINT")
    private Boolean isActive;

    @Column(name = "created_at", nullable = false, insertable = false)
    private LocalDateTime createdAt;
}
