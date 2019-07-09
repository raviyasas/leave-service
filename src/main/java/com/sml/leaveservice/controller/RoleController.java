package com.sml.leaveservice.controller;

import com.sml.leaveservice.model.Role;
import com.sml.leaveservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }
}
