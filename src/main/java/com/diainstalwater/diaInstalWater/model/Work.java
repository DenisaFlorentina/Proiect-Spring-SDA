package com.diainstalwater.diaInstalWater.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "works")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "workid")
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workid;
    @Column
    private String workname;
    @Column
    private float workprice;
    @ManyToOne
    @JoinColumn(name = "clientid", insertable = false, updatable = false)
    private Client client;
    private long clientid;

    @ManyToOne
    @JoinColumn(name = "plumberid", insertable = false, updatable = false)
    private Plumber plumber;
    private long plumberid;

}
