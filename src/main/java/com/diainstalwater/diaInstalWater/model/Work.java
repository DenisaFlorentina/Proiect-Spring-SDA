package com.diainstalwater.diaInstalWater.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "works")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceId;
    @Column
    private String serviceName;
    @Column
    private float servicePrice;


}
