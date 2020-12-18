package com.diainstalwater.diaInstalWater.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    @Column
    private String clientName;
    @Column
    private String clientAddress;

}
