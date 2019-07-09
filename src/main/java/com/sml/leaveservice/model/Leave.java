package com.sml.leaveservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_gen")
    @SequenceGenerator(name = "leave_gen", sequenceName = "leave_seq", allocationSize = 100)
    private Long id;
    private Integer annualLeaves;
    private Integer casualLeaves;
    private Integer totalLeaves;
    private Integer availableLeaves;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id", updatable = false)
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Employee employee;

}
