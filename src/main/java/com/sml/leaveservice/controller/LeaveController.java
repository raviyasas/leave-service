package com.sml.leaveservice.controller;

import com.sml.leaveservice.dto.LeaveDTO;
import com.sml.leaveservice.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @RequestMapping("/employee/{id}")
    public LeaveDTO getLeaves(@PathVariable Long id){
        return leaveService.findLeaveById(id);
    }

}
