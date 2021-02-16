package com.diainstalwater.diaInstalWater.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;



    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    /*@JoinTable(name="user_role",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})*/
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

   /*public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }
/*
    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
     public void addRole(Role role) {
        if (!getRoles().contains(role)) {
            getRoles().add(role);
        }
        if (!role.getUsers().contains(this)){
              role.getUsers().add(this);
        }
    }
}
