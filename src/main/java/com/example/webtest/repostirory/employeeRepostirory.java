package com.example.webtest.repostirory;

import com.example.webtest.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepostirory extends JpaRepository<employee,Integer> {
}
