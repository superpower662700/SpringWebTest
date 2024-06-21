package com.example.webtest.service;

import com.example.webtest.entity.employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface employeeService {
    public List<employee> getAllEmployees();
    public Optional getEmployeeById(int id);
    public String getEmployeeTotalWage(int id);
    public void addEmployee(employee employee);
    public void updateEmployee(employee employee);
    public void deleteEmployee(int id);
}
