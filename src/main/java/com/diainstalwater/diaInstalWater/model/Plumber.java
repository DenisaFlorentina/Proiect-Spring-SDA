package com.diainstalwater.diaInstalWater.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "plumbers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "plumberid")
@NoArgsConstructor
@AllArgsConstructor
public class Plumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long plumberid;
    @Column
    private String plumbername;
    //@OneToMany(mappedBy = "plumber")
    //private List<Work> works;
}
