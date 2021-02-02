package com.diainstalwater.diaInstalWater.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "clients")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "clientid")
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientid;
    @Column
    private String clientname;
    @Column
    private String clientaddress;
    @Column
    private String clientphone;
    @Column
    private String clientmail;


   @OneToMany(mappedBy = "client")
   private List<Work> works;

}
