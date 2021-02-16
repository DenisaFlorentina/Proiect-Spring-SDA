package com.diainstalwater.diaInstalWater.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "works")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "workid")
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workid;
    @Column
    private String workname;
    @Column
    private Float workprice;

    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false, updatable = false)
    private Client client;
    private Long clientid;

    @ManyToOne
    @JoinColumn(name = "plumberid", insertable = false, updatable = false)
    private Plumber plumber;
    private Long plumberid;



}
