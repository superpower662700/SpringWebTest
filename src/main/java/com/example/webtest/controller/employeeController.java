package com.example.webtest.controller;

import com.example.webtest.entity.employee;
import com.example.webtest.entity.role;
import com.example.webtest.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")

public class employeeController {
    @Autowired
    employeeService employeeService;

    @GetMapping
    public ResponseEntity getEmployees() {
        List<employee> e = employeeService.getAllEmployees();
        return ResponseEntity.ok(e);
    }

    @GetMapping("/totalwage")
    public ResponseEntity totalwage(@RequestParam int employeeId) {
        String tatolwage = employeeService.getEmployeeTotalWage(employeeId);
        return ResponseEntity.ok(tatolwage);
    }
    @PatchMapping       
    public ResponseEntity getEmployee(@RequestParam int employeeId) {
        Optional<employee> e = employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(e);
    }

    @PostMapping()
    public ResponseEntity addEmployee(@RequestParam String email, String firstName,
                                        String lastName, String address, String phoneNumber, role roleId , int experience) {
        employee e = new employee();
        e.setAddress(address);
        e.setEmail(email);
        e.setLastName(lastName);
        e.setFirstName(firstName);
        e.setExperience(experience);
        e.setRoleId(roleId);
        e.setPhoneNumber(phoneNumber);
        employeeService.addEmployee(e);
        return ResponseEntity.ok("success");
    }

    @PutMapping()
    public ResponseEntity updateEmployee(@RequestParam int id, String email, String firstName,
                                         String lastName, String address, String phoneNumber, role roleId, int experience) {
        employee e = new employee();
        e.setEmployeeId(id);
        e.setAddress(address);
        e.setEmail(email);
        e.setExperience(experience);
        e.setLastName(lastName);
        e.setFirstName(firstName);
        e.setRoleId(roleId);
        e.setPhoneNumber(phoneNumber);
        employeeService.updateEmployee(e);
        return ResponseEntity.ok("success");
    }
    @DeleteMapping()
    public ResponseEntity deleteEmployee(@RequestParam int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("success");
    }


}
