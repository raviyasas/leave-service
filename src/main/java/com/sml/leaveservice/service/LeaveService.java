package com.sml.leaveservice.service;

import com.sml.leaveservice.dto.EmployeeDTO;
import com.sml.leaveservice.dto.LeaveDTO;
import com.sml.leaveservice.repository.EmployeeRepository;
import com.sml.leaveservice.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public LeaveDTO findLeaveById(Long id) {
        return leaveRepository.findLeavesByEmployeeId(id);
    }

}
