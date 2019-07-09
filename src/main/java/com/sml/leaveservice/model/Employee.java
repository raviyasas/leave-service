package com.sml.leaveservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", allocationSize = 100)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;


    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Leave> leaves;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_department_id", updatable = false)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Department department;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "employee_roles",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    @JsonManagedReference
    private List<Role> roles;
}
