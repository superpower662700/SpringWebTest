package com.example.webtest.service.impl;

import com.example.webtest.entity.employee;
import com.example.webtest.entity.role;
import com.example.webtest.repostirory.employeeRepostirory;
import com.example.webtest.service.employeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeeImpl implements employeeService {

@Autowired
employeeRepostirory _employeeRepository;

    @Override
    public List<employee> getAllEmployees() {
        List<employee> e = _employeeRepository.findAll();

        return e;
    }

    @Override
    public Optional getEmployeeById(int id) {
        Optional<employee> e = _employeeRepository.findById(id);
        return e;
    }

    @Override
    public String getEmployeeTotalWage(int id) {
        employee e = null;
        try {
             e = _employeeRepository.getReferenceById(id);
            role r = e.getRoleId();
            double tatolWage = r.getWage();
            for (int i = 1 ; i <= e.getExperience(); i++) {
                tatolWage = tatolWage + tatolWage*0.2;
            }
            String s = e.getFirstName() + " " + e.getLastName() + " ở vị trí " + r.getName() + " là : " + tatolWage;
            return s;
        }
        catch (EntityNotFoundException mes) {
            return "Không tồn tại nhân viên có id là " + id;
        }

    }

    @Override
    public void addEmployee(employee employee) {
        _employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(employee employee) {
        _employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        _employeeRepository.deleteById(id);
    }
}
