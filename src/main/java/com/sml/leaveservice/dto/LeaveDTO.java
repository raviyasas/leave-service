package com.sml.leaveservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LeaveDTO implements Serializable {

    private Integer annualLeaves;
    private Integer casualLeaves;
    private Integer totalLeaves;
    private Integer availableLeaves;
}
