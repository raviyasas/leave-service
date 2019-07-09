package com.sml.leaveservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_gen")
    @SequenceGenerator(name = "role_gen", sequenceName = "role_seq", allocationSize = 100)
    private Integer id;
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private List<Employee> employees;


}
