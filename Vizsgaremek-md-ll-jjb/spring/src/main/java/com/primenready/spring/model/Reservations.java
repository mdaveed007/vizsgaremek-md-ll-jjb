package com.primenready.spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "table_id", nullable = false)
    private Integer tableId;

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime reservationDate;

    @Column(name = "guest_count", nullable = false)
    private Integer guestCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus reservationStatus;

    @Column(name = "special_requests", nullable = false)
    private String specialRequests;

    @Column(name = "created_at", nullable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;
}
