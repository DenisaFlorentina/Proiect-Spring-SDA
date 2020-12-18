package com.diainstalwater.diaInstalWater.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "plumbers")
public class Plumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long plumberId;
    @Column
    private String plumberName;
}
