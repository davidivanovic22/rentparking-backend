package com.example.rentparking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.*;
import java.util.*;
import javax.persistence.*;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Role extends Auditable implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "ROLE_ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    @ToString.Exclude
    private List<User> users;

    @Override
    public String getAuthority() {
        return "ROLE_" + getName();
    }

}