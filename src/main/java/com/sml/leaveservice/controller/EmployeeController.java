package com.sml.leaveservice.controller;

import com.sml.leaveservice.dto.EmployeeDTO;
import com.sml.leaveservice.model.Employee;
import com.sml.leaveservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id){
        if(id != null) {
            return employeeService.findEmployeeById(id);
        }
        return null;
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity addNewEmployee(@RequestBody Employee employee){
        Map<String, Object> response = new HashMap<>();

        if(employee != null) {
            employeeService.addEmployee(employee);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity addNewEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();

        try {
            if(employeeService.findEmployeeById(id).isPresent()){
                employeeService.updateEmployee(employeeDTO);
            }
        }catch (Exception e){
            response.put("Status", "Error");
            response.put("Message", "Error");
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/remove/{id}")
    public void deleteEmployee(@PathVariable Long id){
        if(id != null) {
            employeeService.removeEmployee(id);
        }
    }

}
