package com.sml.leaveservice.service;

import com.sml.leaveservice.dto.EmployeeDTO;
import com.sml.leaveservice.model.Employee;
import com.sml.leaveservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();

        if(employeeDTO.getFirstName() != null) {
            employee.setFirstName(employeeDTO.getFirstName());
        }
        if(employeeDTO.getLastName() != null) {
            employee.setLastName(employeeDTO.getLastName());
        }
        if(employeeDTO.getEmail() != null) {
            employee.setEmail(employeeDTO.getEmail());
        }
        if(employeeDTO.getContactNumber() != null) {
            employee.setContactNumber(employeeDTO.getContactNumber());
        }

        employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public void removeEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
