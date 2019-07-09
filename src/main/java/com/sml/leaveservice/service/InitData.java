package com.sml.leaveservice.service;

import com.sml.leaveservice.model.Department;
import com.sml.leaveservice.model.Employee;
import com.sml.leaveservice.model.Leave;
import com.sml.leaveservice.model.Role;
import com.sml.leaveservice.repository.DepartmentRepository;
import com.sml.leaveservice.repository.EmployeeRepository;
import com.sml.leaveservice.repository.LeaveRepository;
import com.sml.leaveservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        Role role = new Role();
        role.setRoleName("ADMIN");
        roleRepository.save(role);

        Role role2 = new Role();
        role2.setRoleName("USER");
        roleRepository.save(role2);

        List<Role> adminRole = new ArrayList<>();
        adminRole.add(role);
        adminRole.add(role2);

        List<Role> userRole = new ArrayList<>();
        userRole.add(role2);

        Department department = new Department();
        department.setDepartmentName("IT");
        departmentRepository.save(department);

        Department department2 = new Department();
        department2.setDepartmentName("ACC");
        departmentRepository.save(department2);

        Employee employee = new Employee();
        employee.setFirstName("Ashan");
        employee.setLastName("Madu");
        employee.setEmail("ashan@live.com");
        employee.setContactNumber("0712480553");
        employee.setDepartment(department);
        employee.setRoles(adminRole);
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Kamal");
        employee2.setLastName("Gune");
        employee2.setEmail("gune@gmail.com");
        employee2.setContactNumber("0775643352");
        employee2.setDepartment(department2);
        employee2.setRoles(userRole);
        employeeRepository.save(employee2);

        Leave leave = new Leave();
        leave.setTotalLeaves(28);
        leave.setAnnualLeaves(21);
        leave.setCasualLeaves(7);
        leave.setAvailableLeaves(10);
        leave.setEmployee(employee);
        leaveRepository.save(leave);

        Leave leave2 = new Leave();
        leave2.setTotalLeaves(28);
        leave2.setAnnualLeaves(14);
        leave2.setCasualLeaves(7);
        leave2.setAvailableLeaves(13);
        leave2.setEmployee(employee2);
        leaveRepository.save(leave2);

    }
}
