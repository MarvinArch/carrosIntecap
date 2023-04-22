package com.api.v1.autos.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="car")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Long id;
    private String marca;
    private String modelo;
    private String precio;

}
