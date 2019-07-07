package com.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_name", nullable = false)
    private String name;
    @Column(name = "car_type")
    private String type;
    @Column(name = "car_engine")
    private Double engine;
    @Column(name = "car_year")
    private Long year;
}
